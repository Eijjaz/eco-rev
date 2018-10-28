package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

public class user {
    public String username;
    public String password;
    public String emailaddress;
    public int ID;
    public String picture;

//constructor
    public user()
    {
         ID = 0;
         username = "";
         password = "";
         emailaddress = "";
         picture = "";
    }

//overload constructor
    public user(int _id,String _username,String _password,String _emailaddress,String _picture)
    {
        ID = _id;
        username = _username;
        password = _password;
        emailaddress = _emailaddress;
        picture = _picture;
    }
//methods
    public void changename(String _newusername)
    {
        username = _newusername;
    }
    public void changepassword(String _newpassword)
    {
        password = _newpassword;
    }
    public void changeemail(String _newemailaddress)
    {
        emailaddress = _newemailaddress;
    }
    public void changepicture(String _newpicture)
    {
        picture = _newpicture;
    }
//another method return boolean
    public boolean checkuserpassword(String _username, String _password)
    {
        if(username.equals(_username)&& password.equals(_password))
            return true;
        else
            return false;
    }
}
