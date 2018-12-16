package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quizscore implements Parcelable  {
    public ArrayList<Integer> marks;
    public ArrayList<ArrayList<Boolean>> questions;//flag for questions answered

    public int topquizmark ()
    {
        return Collections.max(marks);
    }
    public int totalquizmark ()
    {
        int sum = 0;
        for (int a :
                marks) {
            sum += a;
        }
        return sum;
    }
    public quizscore(int Theme1marks,int Theme2marks, int Theme3marks, int Theme4marks)
    {
        marks = new ArrayList<Integer>();
        marks.add(Theme1marks);
        marks.add(Theme2marks);
        marks.add(Theme3marks);
        marks.add(Theme4marks);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(marks);
        dest.writeList(questions);
    }

    private quizscore(Parcel in) {
        marks = new ArrayList<Integer>();
        in.readList(marks, Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<quizscore> CREATOR
            = new Parcelable.Creator<quizscore>() {
        public quizscore createFromParcel(Parcel in) {
            return new quizscore(in);
        }

        public quizscore[] newArray(int size) {
            return new quizscore[size];
        }
    };
}
