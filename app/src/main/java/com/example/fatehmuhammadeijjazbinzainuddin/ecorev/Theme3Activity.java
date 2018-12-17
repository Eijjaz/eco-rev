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

public class Theme3Activity extends AppCompatActivity {
    public user currUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme3);
        currUser = (user)getIntent().getParcelableExtra("currUser");
        LinearLayout ly = (LinearLayout) findViewById(R.id.themeLayout);
        ly.setGravity(Gravity.CENTER);
        ArrayList<String> Topics = new ArrayList<String>();
        Topics.add("3.1 Business Growth");
        Topics.add("3.2 Revenue");
        Topics.add("3.3 Production");
        Topics.add("3.4 Costs");
        Topics.add("3.5 Profit");
        Topics.add("3.6 Market Structure");
        Topics.add("3.7 Perfect Competition");
        Topics.add("3.8 Monopolistic Competition");
        Topics.add("3.9 Oligopoly");
        Topics.add("3.10 Monopoly");
        Topics.add("3.11 Monopsony");
        Topics.add("3.12 Contestability");
        Topics.add("3.13 Business Objectives");
        Topics.add("3.14 Efficiency");
        Topics.add("3.15 Evaluating Competition and Monopoly");
        Topics.add("3.16 Government Intervention and Product Markets");
        Topics.add("3.17 Demand for Labour");
        Topics.add("3.18 Supply of Labour");
        Topics.add("3.19 Wage Determination");
        Topics.add("3.20 Government Intervention in Labour Markets");

        for (String t:Topics) {
            View v = new View(this);
            v.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rectanglerounded));
            GradientDrawable bgDrawable = (GradientDrawable)v.getBackground();
            bgDrawable.setColor(Color.rgb(241,156,0));
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
                    Intent intent = new Intent(Theme3Activity.this,ContentView.class);
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
        final String theme = "t3";
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Theme3Activity.this,QuizView.class);
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
