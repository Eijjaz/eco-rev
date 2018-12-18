package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;


public class LogInActivity extends AppCompatActivity {

    public userledger ul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        this.getWindow().getDecorView().setBackgroundColor(Color.parseColor("white"));

        boolean isNew = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("fromSignup")) {
                isNew = extras.getBoolean("fromSignup", false);

            }
        }
        ul = new userledger("userpassword.txt",this);

        if (!isNew)
        {
            ul.DuplicateAsset();
        }

        ul.readdatabase();


        Button Loginbutton  = (Button) findViewById(R.id.ButtonLogin);
        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Usernametb =(EditText) findViewById(R.id.Username);

                EditText Passwordtb =(EditText) findViewById(R.id.Password);

                //if (Usernametb.getText().toString().equals("cyberqid") && Passwordtb.getText().toString().equals("zaq190op"))
                if (ul.checkusers(Usernametb.getText().toString(), Passwordtb.getText().toString()))
                {
                    user currentUser = ul.getuser(Usernametb.getText().toString());
                    Toast.makeText(getApplicationContext(), "Success! Welcome " + currentUser.username, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LogInActivity.this,MainActivity.class);
                    intent.putExtra("currUser",currentUser);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(), "The username or password is wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

        final Button SignUpButt = (Button) findViewById(R.id.ButtonSignUp);
        SignUpButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(LogInActivity.this,Signup.class);
                    startActivity(intent);


            }
        });
    }

}
