package com.aca.andrewott.tagd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignInActivity extends AppCompatActivity {

    Button mBtnSignIn;
    EditText mGamerTag;
    EditText mPassword;
    CheckBox mKeepMeSignedIn;
    CheckBox mAgreeToTerms;
    TextView attemptText;
    TextView attemptsNum;
    int counter = 5;

    //TODO Initialize all these dudes too fam

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        mKeepMeSignedIn = (CheckBox) findViewById(R.id.keepMeSignedIn);
        mAgreeToTerms = (CheckBox) findViewById(R.id.agreeToTerms);

        mGamerTag = (EditText) findViewById(R.id.editTextGamertag);
        mPassword = (EditText) findViewById(R.id.editTextPassword);
        attemptText = (TextView) findViewById(R.id.attemptText);
        attemptsNum = (TextView) findViewById(R.id.attemptsNum);


        //TODO Whatever comes next from here lolol

        mBtnSignIn = (Button) findViewById(R.id.btnGetStarted);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO bout to mess around in here

                if(mGamerTag.getText().toString().equals("admin") &&
                        mPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Down the rabbit hole...",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Try again later fam..."
                            ,Toast.LENGTH_SHORT).show();

                            attemptsNum.setVisibility(View.VISIBLE);
                    counter--;
                    attemptsNum.setText(Integer.toString(counter));

                    if (counter == 0) {
                        mBtnSignIn.setEnabled(false);
                        Intent intent = new Intent(getApplicationContext(), HomeScreenActivity.class);
                        startActivity(intent);


            }
        }
    }
});}}













