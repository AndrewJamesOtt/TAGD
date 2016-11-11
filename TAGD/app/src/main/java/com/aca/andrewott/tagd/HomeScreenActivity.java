package com.aca.andrewott.tagd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity {

    Button mBtnSignIn;
    Button mBtnSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_activity);

        mBtnSignIn = (Button) findViewById(R.id.btnSignIn1);
        mBtnSignUp = (Button) findViewById(R.id.btnSignUp1);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(getApplicationContext() , SignInActivity.class);
                startActivity(intent);
            }
        });
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(getApplicationContext() ,SignUpActivity.class);
                startActivity(intent);
            }
        });
}}
