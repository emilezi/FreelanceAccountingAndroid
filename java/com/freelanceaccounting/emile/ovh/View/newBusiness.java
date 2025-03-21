package com.freelanceaccounting.emile.ovh.View;

import com.freelanceaccounting.emile.ovh.Class.User;
import com.freelanceaccounting.emile.ovh.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
     * newBusiness view class.
     *
     * @author Emile Z.
     */

public class newBusiness extends AppCompatActivity {

    Context context;
    Button btn_new_business;
    EditText first_name_input, last_name_input, identifier_input, email_input, phone_input, SIREN_input, SIRET_input, date_input, taxation_input, password_input;
    String first_name, last_name, identifier, email, phone, SIREN, SIRET, date, taxation, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_business);

        btn_new_business = (Button)findViewById(R.id.btn_new_business);

        first_name_input = findViewById(R.id.first_name);
        last_name_input = findViewById(R.id.last_name);
        identifier_input = findViewById(R.id.identifier);
        email_input = findViewById(R.id.email);
        phone_input = findViewById(R.id.phone);
        SIREN_input = findViewById(R.id.SIREN);
        SIRET_input = findViewById(R.id.SIRET);
        date_input = findViewById(R.id.creation_date);
        taxation_input = findViewById(R.id.taxation);
        password_input = findViewById(R.id.password);

        btn_new_business.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                first_name = first_name_input.getText().toString().trim();
                last_name = last_name_input.getText().toString().trim();
                identifier = identifier_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                phone = phone_input.getText().toString().trim();
                SIREN = SIREN_input.getText().toString().trim();
                SIRET = SIRET_input.getText().toString().trim();
                date = date_input.getText().toString().trim();
                taxation = taxation_input.getText().toString().trim();
                password = password_input.getText().toString().trim();

                User Database = new User(newBusiness.this);

                Database.firstUser(SIREN, SIRET, date, taxation, first_name, last_name, identifier, email, phone, password);

                if(SIREN.isEmpty() || SIRET.isEmpty() || date.isEmpty() || taxation.isEmpty() || first_name.isEmpty() || last_name.isEmpty() || identifier.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()){

                }else{
                    switchActivitieshomeMenu();
                }

            }

        });

    }

    private void switchActivitieshomeMenu(){
        Intent switchActivityIntent = new Intent(this, homeApplication.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesnewBusiness(){
        Intent switchActivityIntent = new Intent(this, newBusiness.class);
        startActivity(switchActivityIntent);
    }

}
