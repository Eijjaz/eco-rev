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
import android.webkit.WebView;

import java.util.ArrayList;

public class Theme4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme4);

       LinearLayout ly = (LinearLayout) findViewById(R.id.themeLayout);
        ly.setGravity(Gravity.CENTER);
        ArrayList<String> Topics = new ArrayList<String>();
        Topics.add("4.1 Globalisation");
        Topics.add("4.2 Specialisation and Trade");
        Topics.add("4.3 The Terms of Trade");
        Topics.add("4.4 Trading Blocs");
        Topics.add("4.5 Common Markets and Monetary Unions");
        Topics.add("4.6 The World Trade Organisation");
        Topics.add("4.7 Restrictions on Free Trade");
        Topics.add("4.8 Balance of Payments Issues");
        Topics.add("4.9 Exchange Rate Systems");
        Topics.add("4.10 The Impact of Changes in Exchange Rates");
        Topics.add("4.11 International Competitiveness");
        Topics.add("4.12 Inequality and Poverty");
        Topics.add("4.13 Redistribution of Income and Wealth");
        Topics.add("4.14 Measures of Development");
        Topics.add("4.15 Factors influencing Growth and Development");
        Topics.add("4.16 Strategies influencing Growth and Development");
        Topics.add("4.17 Financial Markets");
        Topics.add("4.18 Central Banks and Financial Market Regulation");
        Topics.add("4.19 Public Expenditure");
        Topics.add("4.20 Taxation");
        Topics.add("4.21 Public Sector Finances");
        Topics.add("4.22 Macroeconomic Policies in a Global Market");

        for (String t:Topics) {
            View v = new View(this);
            v.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rectanglerounded));
            GradientDrawable bgDrawable = (GradientDrawable)v.getBackground();
            bgDrawable.setColor(Color.rgb(16,67,160));
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
                    Intent intent = new Intent(Theme4Activity.this,ContentView.class);
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
        final String theme = "t4";
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Theme4Activity.this,QuizView.class);
                intent.putExtra("theme", theme);
                startActivity(intent);
            }
        });
        rl.addView(v);
        rl.addView(tv);

        ly.addView(rl);
    }
}
