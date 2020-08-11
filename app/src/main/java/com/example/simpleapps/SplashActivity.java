package com.example.simpleapps;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


public class SplashActivity extends AppCompatActivity {

    public static final int SPLASH_TIME = 1000;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ButterKnife.bind(this);

        start();

    }


    private void start() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, SPLASH_TIME);

    }
}


