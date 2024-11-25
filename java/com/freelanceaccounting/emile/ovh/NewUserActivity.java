package com.freelanceaccounting.emile.ovh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewUserActivity extends AppCompatActivity {

    Button btn_close_newuseractivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_activity);

        btn_close_newuseractivity = (Button)findViewById(R.id.btn_close);

        btn_close_newuseractivity.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                finish();
            }

        });

    }

}
