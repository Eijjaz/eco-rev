package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.RelativeLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class QuizView extends AppCompatActivity {
    public String theme = ""; // or other values
    public int quesNum = 1;
    public int wvid = 1;
    public int ans = 0;
    public user currUser;
    public boolean answered;
    public Button mybuttNext;
    static public int NUM_QUES = 5;
    public int themeid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_view);
        currUser = (user) getIntent().getParcelableExtra("currUser");

        Bundle b = getIntent().getExtras();
        answered = false;
        if (b != null)
            theme = b.getString("theme");

        themeid = Integer.valueOf(theme.substring(1,2)) - 1;
        currUser.marks.marks.set(themeid,0);

        CreateFramework();
        CreateQuestion();
        LinearLayout ly = (LinearLayout) findViewById(R.id.contentLayout);
        LinearLayout hly = new LinearLayout(this);
        hly.setOrientation(LinearLayout.HORIZONTAL);

        mybuttNext = new Button(this);
        mybuttNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quesNum <= NUM_QUES) {
                    quesNum++;
                    SetAllAnswerToBlack();
                    CreateQuestion();
                }
                else{
                    DeleteQuest();

                }

                answered = false;
                mybuttNext.setEnabled(false);
                SetAllAnswerToBlack();
            }
        });
        mybuttNext.setText("Next");
        mybuttNext.setEnabled(false);

//        Button mybuttPrev = new Button(this);
//        mybuttPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (quesNum >= 1)
//                {
//                    quesNum--;
//                    SetAllAnswerToBlack();
//                    CreateQuestion();
//                }
//            }
//        });
//        mybuttPrev.setText("Previous");
//        //RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)mybuttNext.getLayoutParams();
//        //params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        //mybuttNext.setLayoutParams(params);
//
//        hly.addView(mybuttPrev);
        hly.addView(mybuttNext);
        ly.addView(hly);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void CreateFramework() {
        WebView wv = new WebView(this);
        wv.setId(wvid);
        //wv = (WebView) findViewById(R.id.webView1);
        //wv.loadUrl("file:///android_asset/"+"ques_"+theme+"_"+String.valueOf(quesNum) + ".html");

        LinearLayout ly = (LinearLayout) findViewById(R.id.contentLayout);
        ly.addView(wv);

        BufferedReader reader = null;

        int count = 0;
        String q = "ABCD";
        ViewGroup.MarginLayoutParams marginTv = new ViewGroup.MarginLayoutParams(1000, 200);
        marginTv.topMargin = 10;
        marginTv.leftMargin = 10;

        ViewGroup.MarginLayoutParams marginTvq = new ViewGroup.MarginLayoutParams(80, 160);
        marginTvq.topMargin = 10;
        marginTvq.leftMargin = 10;

        while (count < 4) {
            LinearLayout hly = new LinearLayout(this);
            hly.setOrientation(LinearLayout.HORIZONTAL);

            TextView tvq = new TextView(this);
            tvq.setId(count + 6);
            tvq.setText(q.substring(count, count + 1));
            tvq.setTextSize(16);
            tvq.setLayoutParams(marginTvq);
            tvq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView vv = (TextView) v;

                    if (!answered) {

                        SetAllAnswerToBlack();
                        if (v.getId() == ans) {
                            vv.setTextColor(Color.rgb(0, 255, 0));
                            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                            int x = currUser.marks.marks.get(themeid);
                            x++;
                            currUser.marks.marks.set(themeid,x);
                        } else {
                            vv.setTextColor(Color.rgb(255, 0, 0));
                            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
                        }

                        //QuizView qqq = (QuizView) v.getParent();
                        answered = true;

                        mybuttNext.setEnabled(true);

                    }
                }
            });

            hly.addView(tvq);

            TextView tv = new TextView(this);

            tv.setId(count + 2);
            tv.setTextSize(16);
            tv.setLayoutParams(marginTv);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int ansChoosed = v.getId();
                    if (!answered) {
                        SetAllAnswerToBlack();
                        TextView vv = (TextView) v;
                        if ((ansChoosed - 1) == ans) {
                            vv.setTextColor(Color.rgb(0, 255, 0));
                            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                            int x = currUser.marks.marks.get(themeid);
                            x++;
                            currUser.marks.marks.set(themeid,x);

                        } else {
                            vv.setTextColor(Color.rgb(255, 0, 0));
                            Toast.makeText(getApplicationContext(), "Wrong! ", Toast.LENGTH_LONG).show();
                        }

                        answered = true;
                        mybuttNext.setEnabled(true);
                        if (quesNum == NUM_QUES) {
                            mybuttNext.setText("End");
                        }
                    }

                }
            });

            hly.addView(tv);
            ly.addView(hly);

            count++;
            //q++;
        }


    }

    public void DeleteQuest() {
        WebView wv = findViewById(wvid);//new WebView(this);
        wv.destroy();
        int count = 0;
        while (count < 8) {

                TextView tv = findViewById(count + 2);
               tv.setText("");
                count++;

            }



        TextView tv = findViewById(2);
        //int rr = Integer.valueOf(theme.substring(1,2));
        String t = "Your total marks is " + currUser.marks.marks.get(themeid).toString() ;
        tv.setText(t);

    }

    public void CreateQuestion() {
        WebView wv = findViewById(wvid);//new WebView(this);
        wv.loadUrl("file:///android_asset/" + "ques_" + theme + "_" + String.valueOf(quesNum) + ".html");


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("ans_" + theme + "_" + String.valueOf(quesNum) + ".txt")));
            String mline;
            int count = 0;

            while (count < 4) {
                if ((mline = reader.readLine()) != null) {
                    TextView tv = findViewById(count + 2);
                    tv.setText(mline);
                    count++;

                }

            }

            if ((mline = reader.readLine()) != null) {
                // Log.i("a",mline);
                ans = Integer.valueOf(mline);

            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }

    }

    public void SetAllAnswerToBlack() {
        int gg = 2;
        while (gg < 10) {
            TextView ttv = (TextView) findViewById(gg);
            ttv.setTextColor(Color.parseColor("black"));
            gg++;
        }
    }
}
