package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class ContentView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view);
        Bundle b = getIntent().getExtras();
        String filename = ""; // or other values
        if(b != null)
            filename = b.getString("filename");
        WebView wv = new WebView(this);
        
        wv.loadUrl("file:///android_asset/"+filename);

        LinearLayout ly = (LinearLayout) findViewById(R.id.contentLayout);
        ly.addView(wv);

    }

}
