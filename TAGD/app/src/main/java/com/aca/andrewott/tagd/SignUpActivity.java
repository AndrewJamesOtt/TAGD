package com.aca.andrewott.tagd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mSignUpGamertag;
    EditText mSignUpEmail;
    EditText mSignUpPassword;
    Button mGetVerified;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), ActivityMain.class));
        }

        final EditText mSignUpGamertag = (EditText) findViewById(R.id.signUpGamertag);
        final EditText mSignUpEmail = (EditText) findViewById(R.id.signUpEmail);
        final EditText mSignUpPassword = (EditText) findViewById(R.id.signUpPassword);
        final Button mGetVerified = (Button) findViewById(R.id.btnGetVerified);

        progressDialog = new ProgressDialog(this);

        mGetVerified.setOnClickListener(this);


    }

    private void registerUser() {
        String gamertag = mSignUpGamertag.getText().toString().trim();
        String email = mSignUpEmail.getText().toString().trim();
        String password = mSignUpPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(gamertag)) {
            Toast.makeText(this, "Please enter gamertag!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email!", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("This Might Be Working...!");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), ActivityMain.class));

                        } else {

                            Toast.makeText(SignUpActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v == mGetVerified){
            registerUser();
    }
}}
