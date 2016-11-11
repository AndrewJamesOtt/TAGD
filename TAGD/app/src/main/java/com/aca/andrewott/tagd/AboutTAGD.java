package com.aca.andrewott.tagd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AboutTAGD extends AppCompatActivity {

    Button mBtnReturn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_the_app);

        mBtnReturn = (Button) findViewById(R.id.mBtnReturn);

        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(getApplicationContext() , ActivityMain.class);
                startActivity(intent);
            }
        });

}}
