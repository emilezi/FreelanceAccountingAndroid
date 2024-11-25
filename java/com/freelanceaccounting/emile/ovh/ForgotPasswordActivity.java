package com.freelanceaccounting.emile.ovh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button btn_close_forgotpasswordactivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);

        btn_close_forgotpasswordactivity = (Button)findViewById(R.id.btn_close);

        btn_close_forgotpasswordactivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                finish();
            }

        });

    }

}