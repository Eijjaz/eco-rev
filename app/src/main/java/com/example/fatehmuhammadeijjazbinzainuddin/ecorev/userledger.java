package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.content.Context;
import android.security.keystore.UserNotAuthenticatedException;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userledger {
    public List<user> users;

    public String filename;
    public userledger (){}
    public Context context;

    public userledger(String _filename, Context _context){
        users = new ArrayList<user>();
        filename = _filename;
        context = _context;
        readdatabase();

    }

    public boolean checkusers(String username, String password){
        for (user u :
                users) {
           if (u.checkuserpassword(username,password))
               return true;
        }
        return false;
    }

    public user getuser(String username)
    {
        for (user u :
                users) {
            if (u.username.equals(username))
                return u;
        }
        return null;
    }
    public void createuser(user u)
    {
        users.add(u);
    }

    public void readdatabase()
    {
        File file = new File(filename);
        //Read text from file
        StringBuilder text = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(filename)));
            String mline;
            int count = 0;


            while ((mline = reader.readLine()) != null) {
                String [] lines = mline.split(",");
                quizscore q = new quizscore(Integer.parseInt(lines[4]),Integer.parseInt(lines[5]),Integer.parseInt(lines[6]),Integer.parseInt(lines[7]));
                user u = new user(Integer.parseInt(lines[0]),lines[1],lines[2],lines[3],"",q);
                users.add(u);
                //users.put(lines[0],lines[1]);

            }

        }
        catch (IOException e) {
            Log.d("CREATION",e.getMessage());
            //You'll need to add proper error handling here
        }
    }

}
