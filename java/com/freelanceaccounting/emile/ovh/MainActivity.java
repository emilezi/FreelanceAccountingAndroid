package com.freelanceaccounting.emile.ovh;

import com.freelanceaccounting.emile.ovh.Class.User;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.freelanceaccounting.emile.ovh.View.newDatabase;
import com.freelanceaccounting.emile.ovh.View.homeMenu;

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
            User Database = new User(MainActivity.this);
            Cursor cursor = Database.readData();
            if(cursor.getCount() == 0){
                return false;
            }else{
                return true;
            }
        }

}