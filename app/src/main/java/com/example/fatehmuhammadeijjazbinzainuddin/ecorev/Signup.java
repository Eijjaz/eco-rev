package com.example.fatehmuhammadeijjazbinzainuddin.ecorev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button SignUpButt = (Button) findViewById(R.id.ButtonSignUp);
        SignUpButt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText newUsername = (EditText) findViewById(R.id.NewUsername);
                EditText newPassword = (EditText) findViewById(R.id.NewPassword);
                EditText confPassword = (EditText) findViewById(R.id.ConfirmPassword);

                if (newUsername.getText().toString() != "")
                {
                    //Check username exist or not

                    if (newPassword.getText().toString() != confPassword.getText().toString())
                    {
                        userledger ul = new userledger("userpassword.txt",v.getContext());
                        ul.readdatabase();
                        ul.addUser(newUsername.getText().toString(),newPassword.getText().toString(),"");
                        Intent intent = new Intent(Signup.this,LogInActivity.class);
                        intent.putExtra("fromSignup",true);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "new password not equal to confirm password", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please enter new username", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
