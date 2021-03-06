package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class user implements Parcelable {
    public String username;
    public String password;
    public String emailaddress;
    public int ID;
    public String picture;
    public quizscore marks;
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
    public user(int _id,String _username,String _password,String _emailaddress,String _picture, quizscore q)
    {
        ID = _id;
        username = _username;
        password = _password;
        emailaddress = _emailaddress;
        picture = _picture;
        marks = q;
    }

    public String dataToString()
    {
        return String.valueOf(ID) + ","+username+ ","+password+","+emailaddress+","+marks.marks.get(0)+","+marks.marks.get(1)+","+marks.marks.get(2)+","+marks.marks.get(3);
    }
//methods
    public void setName(String _newusername)
    {
        username = _newusername;
    }
    public void setPassword(String _newpassword)
    {
        password = _newpassword;
    }
    public void setEmail(String _newemailaddress)
    {
        emailaddress = _newemailaddress;
    }
    public void setPicture(String _newpicture)
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(emailaddress);
        dest.writeInt(ID);

        dest.writeParcelable(marks, flags);
    }

    public static final Parcelable.Creator<user> CREATOR = new Parcelable.Creator<user>() {
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        public user[] newArray(int size) {
            return new user[size];
        }
    };

    private user(Parcel in) {
        username = in.readString();
        password = in.readString();
        emailaddress = in.readString();
        ID = in.readInt();
        this.marks = in.readParcelable(quizscore.class.getClassLoader());
    }
}
