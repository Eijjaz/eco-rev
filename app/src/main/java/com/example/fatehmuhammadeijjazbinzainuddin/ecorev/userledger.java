package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.content.Context;
import android.os.Build;
import android.security.keystore.UserNotAuthenticatedException;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
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
        //DuplicateAsset();
        //readdatabase();

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
    public void addUser(String username, String password,String email)
    {
        users.add(new user(users.size(),username,password,email,"",new quizscore(0,0,0,0)));
        writeToDatabase();
    }

    public void DuplicateAsset()
    {
        File newFile =  new File( context.getFilesDir(),filename);//new File(filename);

            try {
                InputStream in = context.getAssets().open(filename);
                OutputStream out = new FileOutputStream(newFile);
                try {
                    // Transfer bytes from in to out
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                } finally {
                    out.close();
                }
            } catch (IOException e)
            {

            }finally {

            }



    }


    public void readdatabase()
    {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream( new File( context.getFilesDir(),filename))));
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void writeToDatabase()
    {
        File newFile = new File( context.getFilesDir(),filename);//context.getFileStreamPath(filename);//new File(filename);
        if (newFile.exists())
        {
            try {
                //InputStream in = context.getAssets().open(filename);
                OutputStream out = new FileOutputStream(newFile);

                try {
                    for (user s:
                            users) {
                        byte[] dd = (s.dataToString()+"\n").getBytes(StandardCharsets.UTF_8);
                        out.write(dd,0,dd.length);
                    }
                    // Transfer bytes from in to out
                  //  byte[] buf = new byte[1024];
                    //int len;
                    //while ((len = in.read(buf)) > 0) {

                    //}
                } finally {
                    out.close();
                }
            } catch (IOException e)
            {

            }
        }
    }

}
