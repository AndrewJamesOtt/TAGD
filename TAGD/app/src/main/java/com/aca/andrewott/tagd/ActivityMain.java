package com.aca.andrewott.tagd;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityMain extends AppCompatActivity {

    XboxApiService mXboxApiService;
    Button mBtnSearchGT;
    Button mBtnRecentGT;
    Button mBtnTagd;
    TextView mGamertagText;
    Button mDialogBtn;
    Button mLogoutBtn;
    String gamerTag = "";


    private static final String API_KEY = BuildConfig.API_KEY;

    //TODO TextView mEnterGT, Make a searchable database for gt's

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGamertagText = (TextView)findViewById(R.id.editTextGT);

        mBtnSearchGT = (Button) findViewById(R.id.btnSearchGT);
        mBtnSearchGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mGamertagText.getText() != "") {
                    gamerTag = mGamertagText.getText().toString();
                }

                HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
                loggin.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                builder.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                //TODO dont leave this here; think I fixed it
                                .addHeader("X-AUTH", "API_KEY")
                                .build();
                        return chain.proceed(request);
                    }
                });
                builder.addInterceptor(loggin);

                OkHttpClient client = builder.build();

                Retrofit restAdapter = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://xboxapi.com")
                        .client(client)
                        .build();

                mXboxApiService = restAdapter.create(XboxApiService.class);
                //TODO watch this log.i
                Call<Xuid> call = mXboxApiService.getXuid(gamerTag);
                call.enqueue(new Callback<Xuid>() {
                    @Override
                    public void onResponse(Call<Xuid> call, Response<Xuid> response) {
                        //Log.i("Does this shit work?", response.body().toString());
                        Intent intent = new Intent(getApplicationContext(), SelectedGT.class);
                        intent.putExtra("gamertag", gamerTag);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Xuid> call, Throwable t) {

                    }
                });
            }
        });

        mBtnRecentGT = (Button) findViewById(R.id.btnRecents);
        mBtnRecentGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RecentGT.class);
                startActivity(intent);
            }
        });

        mBtnTagd = (Button) findViewById(R.id.btnAboutUs);
        mBtnTagd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AboutTAGD.class);
                startActivity(intent);
            }
        });
        mLogoutBtn = (Button) findViewById(R.id.mLogoutBtn);
        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setTitle(R.string.app_name);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Do you want to Log Out?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Intent intent = new Intent(getApplicationContext(), HomeScreenActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}
















