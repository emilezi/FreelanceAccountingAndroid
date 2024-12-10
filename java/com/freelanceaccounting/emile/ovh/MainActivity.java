package com.freelanceaccounting.emile.ovh;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.freelanceaccounting.emile.ovh.View.newBusiness;
import com.freelanceaccounting.emile.ovh.View.newDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent switchActivityIntent = new Intent(this, newDatabase.class);
        startActivity(switchActivityIntent);

        //Intent switchActivityIntent = new Intent(this, newBusiness.class);
        //startActivity(switchActivityIntent);

    }

}