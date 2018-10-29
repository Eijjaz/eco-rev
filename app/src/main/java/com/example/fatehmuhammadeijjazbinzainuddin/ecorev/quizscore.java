package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quizscore {
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
}
