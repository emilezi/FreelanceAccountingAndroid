package com.freelanceaccounting.emile.ovh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_new_user;
    Button btn_forgot_password;
    Button btn_authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btn_new_user = (Button)findViewById(R.id.button2);

        btn_forgot_password = (Button)findViewById(R.id.button1);

        btn_authentication = (Button)findViewById(R.id.button3);

        btn_new_user.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                switchActivitiesNewUser();
            }

        });

        btn_forgot_password.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                switchActivitiesForgotPassword();
            }

        });

    }

    private void switchActivitiesNewUser(){
        Intent switchActivityIntent = new Intent(this, NewUserActivity.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesForgotPassword(){
        Intent switchActivityIntent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(switchActivityIntent);
    }

}