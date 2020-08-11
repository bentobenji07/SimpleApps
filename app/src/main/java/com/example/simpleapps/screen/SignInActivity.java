package com.example.simpleapps.screen;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.simpleapps.R;
import com.example.simpleapps.database.UserData;
import com.example.simpleapps.database.UserMetaData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SignInActivity extends AppCompatActivity{

    public String inputEmail;
    public String inputPassword;
    protected UserData userData;

    private boolean doubleBackToExitPressedOnce = false;
    private boolean visibleOrInvisiblePass = true;



    @BindView(R.id.emailForLogin)
    EditText email;
    @BindView(R.id.passwordForLogin)
    EditText password;
    @BindView(R.id.textWatcherEye)
    ImageView visibleOrInvisiblePassword;
    @BindView(R.id.buttonLogin)
    Button login;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        ButterKnife.bind(this);

        userData = new UserData(getApplicationContext());


        visibleOrInvisiblePassword();
    }

    @OnClick(R.id.buttonLogin)
    public void signIn() {

        inputEmail = email.getText().toString();
        inputPassword = password.getText().toString();

        if (inputEmail.length() == 0) {
            Toast.makeText(this, R.string.wrongpassoremail, Toast.LENGTH_SHORT).show();
            clearForm();
            return;
        }

        if (inputPassword.length() == 0) {
            Toast.makeText(this, R.string.wrongpassoremail, Toast.LENGTH_SHORT).show();
            clearForm();
            return;
        }

            successLogin();

    }

    private void successLogin(){

        UserMetaData metaData = new UserMetaData();

        metaData.setEmail(getResources().getString(R.string.email));
        metaData.setName(getResources().getString(R.string.app_name));

        userData.save(metaData);


        startActivity(new Intent(this, DashboardActivity.class));
        finish();

    }





    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //finish();
            return;
        }
        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.doubleBackPressConfirmation, Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    public void clearForm() {
        email.setText(null);
        password.setText(null);
    }

    private void visibleOrInvisiblePassword() {
        TextWatcher textWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public void afterTextChanged(Editable s) {
                if (password.getText().toString().trim().length() > 0) {
                    visibleOrInvisiblePassword.setVisibility(View.VISIBLE);
                    visibleOrInvisiblePassword.setClickable(true);
                } else {
                    visibleOrInvisiblePassword.setVisibility(View.GONE);
                    visibleOrInvisiblePassword.setClickable(false);
                }
            }
        };
        password.addTextChangedListener(textWatcher);
        visibleOrInvisiblePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!visibleOrInvisiblePass) {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    password.setSelection(password.getText().length());
                    visibleOrInvisiblePassword.setImageResource(R.drawable.icon_eye_1_48px);
                    visibleOrInvisiblePass = true;
                } else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    password.setSelection(password.getText().length());
                    visibleOrInvisiblePassword.setImageResource(R.drawable.icon_eye_2_48px);
                    visibleOrInvisiblePass = false;
                }
            }
        });
    }



}
