package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Theme2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme2);

        LinearLayout ly = (LinearLayout) findViewById(R.id.themeLayout);
        ly.setGravity(Gravity.CENTER);
        ArrayList<String> Topics = new ArrayList<String>();
        Topics.add("2.1 Measures of Economic Performance");
        Topics.add("2.2 The Characteristics of Aggregate Demand");
        Topics.add("2.3 Consumption");
        Topics.add("2.4 Investment");
        Topics.add("2.5 Government Expenditure and Net Trade");
        Topics.add("2.6 Aggregate Supply");
        Topics.add("2.7 National Income");
        Topics.add("2.8 Equilibrium levels of real national output");
        Topics.add("2.9 The Multiplier");
        Topics.add("2.10 Economic Growth");
        Topics.add("2.11 Inflation ");
        Topics.add("2.12 Employment and Unemployment");
        Topics.add("2.13 Balance of Payments");
        Topics.add("2.14 Possible MacroEconomic Objectives");
        Topics.add("2.15 Demand-Side Policies");
        Topics.add("2.16 Supply-Side Policies");
        Topics.add("2.17 Conflicts and trade-offs");


        for (String t:Topics) {
            View v = new View(this);
            v.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rectanglerounded));
            GradientDrawable bgDrawable = (GradientDrawable)v.getBackground();
            bgDrawable.setColor(Color.rgb(0,150,134));
            ViewGroup.MarginLayoutParams lyp = new ViewGroup.MarginLayoutParams(1230, 255);
            lyp.topMargin = 26;

            v.setLayoutParams(lyp);


            TextView tv = new TextView(this);
            ViewGroup.MarginLayoutParams marginTv = new ViewGroup.MarginLayoutParams(1200, 225);
            marginTv.topMargin = 50;
            marginTv.leftMargin = 30;
            tv.setText(t);
            tv.setTextSize(21);
            tv.setTextColor(Color.WHITE);
            tv.setTypeface(null, Typeface.BOLD);
            tv.setLayoutParams(marginTv);
            RelativeLayout rl = new RelativeLayout(this);
            rl.setGravity(Gravity.CENTER);

            final String filename = "t" + t.split(" ")[0]+".html";
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Theme2Activity.this,ContentView.class);
                    intent.putExtra("filename", filename);
                    startActivity(intent);
                }
            });
            rl.addView(v);
            rl.addView(tv);

            ly.addView(rl);
        }


        View v = new View(this);
        v.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rectanglerounded));
        ViewGroup.MarginLayoutParams lyp = new ViewGroup.MarginLayoutParams(1230, 255);
        lyp.topMargin = 26;

        v.setLayoutParams(lyp);


        TextView tv = new TextView(this);
        ViewGroup.MarginLayoutParams marginTv = new ViewGroup.MarginLayoutParams(1200, 225);
        marginTv.topMargin = 50;
        marginTv.leftMargin = 30;
        tv.setText("Quiz");
        tv.setTextSize(21);
        tv.setTextColor(Color.WHITE);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setLayoutParams(marginTv);
        RelativeLayout rl = new RelativeLayout(this);
        rl.setGravity(Gravity.CENTER);
        final String theme = "t2";
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Theme2Activity.this,QuizView.class);
                intent.putExtra("theme", theme);
                startActivity(intent);
            }
        });
        rl.addView(v);
        rl.addView(tv);

        ly.addView(rl);
        //ly.addView();
    }
}