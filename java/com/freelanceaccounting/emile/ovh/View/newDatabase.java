package com.freelanceaccounting.emile.ovh.View;

import com.freelanceaccounting.emile.ovh.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
     * newDatabase view class.
     *
     * @author Emile Z.
     */

public class newDatabase extends AppCompatActivity {

    Button btn_new_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_database);

        btn_new_database = findViewById(R.id.btn_new_database);

        btn_new_database.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                switchActivitiesnewBusiness();
            }

        });

    }

    private void switchActivitiesnewBusiness(){
        Intent switchActivityIntent = new Intent(this, newBusiness.class);
        startActivity(switchActivityIntent);
    }

}
