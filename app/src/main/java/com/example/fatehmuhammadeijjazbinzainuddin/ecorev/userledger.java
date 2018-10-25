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
import java.util.HashMap;
import java.util.Map;

public class userledger {
    public Map<String, String> users;
    public String filename;
    public userledger (){}

    public userledger(String _filename, Context context){
        users = new HashMap<String,String>();

        filename = _filename;
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
                users.put(lines[0],lines[1]);

            }

        }
        catch (IOException e) {
            Log.d("CREATION",e.getMessage());
            //You'll need to add proper error handling here
        }

    }

    public boolean checkusers(String username, String password){
       String val =  users.get(username);
      if (val != null && val.equals(password)){

         return true;

      }
        return false;
    }

    public void createuser(String Username, String Password)
    {
        users.put(Username,Password);
    }

}
