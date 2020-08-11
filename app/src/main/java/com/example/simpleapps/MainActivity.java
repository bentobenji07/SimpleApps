package com.example.simpleapps;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;


import com.example.simpleapps.screen.DashboardActivity;
import com.example.simpleapps.screen.SignInActivity;

import butterknife.ButterKnife;


public class MainActivity extends MainApiData {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initiateApiData();
    }

    //    SWITCH FACE
    protected void backSignIn() {
        startActivity(new Intent(this, SignInActivity.class));
    }

    protected void backHome() {
                startActivity(new Intent(this, DashboardActivity.class));
                finish();


    }
}

