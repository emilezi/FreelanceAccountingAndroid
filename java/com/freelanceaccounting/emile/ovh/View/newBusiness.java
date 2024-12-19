package com.freelanceaccounting.emile.ovh.View;

import com.freelanceaccounting.emile.ovh.Class.User;
import com.freelanceaccounting.emile.ovh.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class newBusiness extends AppCompatActivity {

    Button btn_new_business;
    EditText first_name_input, last_name_input, identifier_input, email_input, phone_input, SIREN_input, SIRET_input, password_input, repassword_input;


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
        password_input = findViewById(R.id.password);
        repassword_input = findViewById(R.id.repassword);

        btn_new_business.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                User Database = new User(newBusiness.this);
                Database.firstUser(first_name_input.getText().toString().trim(),
                        last_name_input.getText().toString().trim(),
                        identifier_input.getText().toString().trim(),
                        email_input.getText().toString().trim(),
                        phone_input.getText().toString().trim(),
                        SIREN_input.getText().toString().trim(),
                        SIRET_input.getText().toString().trim(),
                        password_input.getText().toString().trim());

                switchActivitieshomeMenu();

            }

        });

    }

    private void switchActivitieshomeMenu(){
        Intent switchActivityIntent = new Intent(this, homeMenu.class);
        startActivity(switchActivityIntent);
    }

}
