package com.freelanceaccounting.emile.ovh;

import com.freelanceaccounting.emile.ovh.Class.Bank;
import com.freelanceaccounting.emile.ovh.Class.Database;
import com.freelanceaccounting.emile.ovh.Class.User;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.freelanceaccounting.emile.ovh.View.homeMenu;
import com.freelanceaccounting.emile.ovh.View.newDatabase;

/**
     * Activity management class.
     *
     * @author Emile Z.
     */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean ifData = displayData();

        if(!ifData){
            switchActivitiesnewDatabase();
        }else{
            switchActivitieshomeMenu();
        }

        }

        private void switchActivitiesnewDatabase(){
            Intent switchActivityIntent = new Intent(this, newDatabase.class);
            startActivity(switchActivityIntent);
        }

        private void switchActivitieshomeMenu(){
            Intent switchActivityIntent = new Intent(this, homeMenu.class);
            startActivity(switchActivityIntent);
        }

        protected Boolean displayData(){
            Database Database = new Database(MainActivity.this);
            Cursor cursor = Database.readData();
            if(cursor.getCount() == 0){
                return false;
            }else{
                return true;
            }
        }

}