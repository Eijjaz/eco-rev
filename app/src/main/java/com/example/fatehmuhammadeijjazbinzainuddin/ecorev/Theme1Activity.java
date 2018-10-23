package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Theme1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme1);

        LinearLayout ly = (LinearLayout) findViewById(R.id.themeLayout);
       ly.setGravity(Gravity.CENTER);
       ArrayList<String> Topics = new ArrayList<String>();
        Topics.add("1.1 Economics as a Social Science");
        Topics.add("1.2 Economic Data");
        Topics.add("1.3 The economic problem");
        Topics.add("1.4 Production Possibility Frontiers");
        Topics.add("1.5 Specialisation and the division of labour");
        Topics.add("1.6 Types of Economy");
        Topics.add("1.7 Rational Decision Making");
        Topics.add("1.8 Demand");
        Topics.add("1.9 Price Elasticity of Demand");
        Topics.add("1.10 Income and Cross Elasticites");
        Topics.add("1.11 Supply");
        Topics.add("1.12 Price Determination");
        Topics.add("1.13 The Price Mechanism");
        Topics.add("1.14 Indirect Taxes and Subsidies");
        Topics.add("1.15 Alternative views of consumer behaviour");
        Topics.add("1.16 Types of Market Failure");
        Topics.add("1.17 Externalities");
        Topics.add("1.18 Public Goods");
        Topics.add("1.19 Information Gaps");
        Topics.add("1.20 Government Intervention of Markets");
        Topics.add("1.21 Government Failure");


        for (String t:Topics) {
            View v = new View(this);
            v.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rectanglerounded));
            GradientDrawable bgDrawable = (GradientDrawable)v.getBackground();
            bgDrawable.setColor(Color.rgb(241,102,0));
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
                    Intent intent = new Intent(Theme1Activity.this,ContentView.class);
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
        final String theme = "t1";
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Theme1Activity.this,QuizView.class);
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
