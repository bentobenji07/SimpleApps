package com.example.simpleapps;


import android.support.v7.app.AppCompatActivity;

import com.example.simpleapps.database.UserData;
import com.example.simpleapps.database.UserMetaData;

import java.util.List;


public class MainApiData extends AppCompatActivity {

    private UserData userData;
    protected UserMetaData activeUserMetaData;

    protected void initiateApiData() {
        userData = new UserData(getApplicationContext());
        getActiveUserMetaData();
    }

    private void getActiveUserMetaData() {
        int listUserMetaData = userData.count();

        if (listUserMetaData == 1) {
            backHome();
        }
        if (listUserMetaData == 0) {
            backSignIn();
        }
    }

    protected void backSignIn() {

    }

    protected void backHome() {

    }
}

