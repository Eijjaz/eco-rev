package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;


import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    public user currUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(new CustomView(this));
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();

        //if(b != null)
        currUser = (user)getIntent().getParcelableExtra("currUser");

        FrameLayout theme1lay = (FrameLayout) findViewById(R.id.theme1);


        TextView t1title = (TextView) theme1lay.findViewById(R.id.titleBox);
        TextView t1subtitle = (TextView) theme1lay.findViewById(R.id.subtitleBox);
        ImageView t1image = (ImageView) theme1lay.findViewById(R.id.themeImg);
        TextView t1content = (TextView) theme1lay.findViewById(R.id.content);
        View v = (View) theme1lay.findViewById(R.id.myRectangleView);
        GradientDrawable bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(241,102,0));
        v = (View) theme1lay.findViewById(R.id.bottomRec);
        bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(241,102,0));

        t1title.setText("Theme 1");//"Theme 1");
        t1subtitle.setText("Introduction to Market Failure");
        t1content.setText("In Theme 1 we cover the main aspects of Demand and Supply, Elasticities, Economic Systems, Market Failures and Government Intervention.");
        t1image.setImageResource(R.drawable.loss1);
        theme1lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Theme1Activity.class);
                intent.putExtra("currUser",currUser);
                startActivity(intent);
            }
        });

        FrameLayout theme2lay = (FrameLayout) findViewById(R.id.theme2);
        TextView t2title = (TextView) theme2lay.findViewById(R.id.titleBox);
        TextView t2subtitle = (TextView) theme2lay.findViewById(R.id.subtitleBox);
        ImageView t2image = (ImageView) theme2lay.findViewById(R.id.themeImg);
        TextView t2content = (TextView) theme2lay.findViewById(R.id.content);
         v = (View) theme2lay.findViewById(R.id.myRectangleView);
         bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(0,150,134));
        v = (View) theme2lay.findViewById(R.id.bottomRec);
        bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(0,150,134));


        t2title.setText("Theme 2");
        t2subtitle.setText("The UK Economy, Performance and Policies");
        t2content.setText("In Theme 2 we cover the main aspects of Aggregate Demand and Supply, Economic Growth and Macroeconomic Objectives and Policies. ");
        t2image.setImageResource(R.drawable.theme2image);
        theme2lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Theme2Activity.class);
                intent.putExtra("currUser",currUser);
                startActivity(intent);
            }
        });

        FrameLayout theme3lay = (FrameLayout) findViewById(R.id.theme3);
        TextView t3title = (TextView) theme3lay.findViewById(R.id.titleBox);
        TextView t3subtitle = (TextView) theme3lay.findViewById(R.id.subtitleBox);
        ImageView t3image = (ImageView) theme3lay.findViewById(R.id.themeImg);
        TextView t3content = (TextView) theme3lay.findViewById(R.id.content);
        v = (View) theme3lay.findViewById(R.id.myRectangleView);
        bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(241,156,0));
        v = (View) theme3lay.findViewById(R.id.bottomRec);
        bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(241,156,0));

        t3title.setText("Theme 3");
        t3subtitle.setText("Business Behaviour & the Labour Market");
        t3content.setText(" In Theme 3 we cover the main aspects of  Revenue, Cost and Profit, Market Structures, Labour Markets and Government Intervention.");
        t3image.setImageResource(R.drawable.theme3image);
        theme3lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Theme3Activity.class);
                intent.putExtra("currUser",currUser);
                startActivity(intent);
            }
        });

        FrameLayout theme4lay = (FrameLayout) findViewById(R.id.theme4);
        TextView t4title = (TextView) theme4lay.findViewById(R.id.titleBox);
        TextView t4subtitle = (TextView) theme4lay.findViewById(R.id.subtitleBox);
        ImageView t4image = (ImageView) theme4lay.findViewById(R.id.themeImg);
        TextView t4content = (TextView) theme4lay.findViewById(R.id.content);

        v = (View) theme4lay.findViewById(R.id.myRectangleView);
        bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(16,67,160));
        v = (View) theme4lay.findViewById(R.id.bottomRec);
        bgDrawable = (GradientDrawable)v.getBackground();
        bgDrawable.setColor(Color.rgb(16,67,160));

        t4title.setText("Theme 4");
        t4subtitle.setText("A Global Perspective");
        t4content.setText("In Theme 4 we cover the main aspects of International Economics, Poverty, Inequality, LEDC's, MEDC's and the Financial Sector.");
        t4image.setImageResource(R.drawable.theme4image);
        theme4lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Theme4Activity.class);
                intent.putExtra("currUser",currUser);
                startActivity(intent);
            }
        });

    }

}
