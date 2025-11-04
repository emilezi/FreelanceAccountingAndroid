package com.freelanceaccounting.emile.ovh.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.freelanceaccounting.emile.ovh.Class.Bank;
import com.freelanceaccounting.emile.ovh.Class.User;
import com.freelanceaccounting.emile.ovh.R;
import com.google.android.material.appbar.MaterialToolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class homeUser extends AppCompatActivity{

    User DB_User;

    String first_name, last_name, identifier, email, phone, SIREN, SIRET, date, taxation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_user);

        MaterialToolbar toolbar = findViewById(R.id.toolBar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int ItemID = item.getItemId();

                if(ItemID == R.id.menuHome){
                    switchActivitiesHome();
                }else if(ItemID == R.id.menuBank){
                    switchActivitiesBank();
                }else if(ItemID == R.id.menuBusiness){
                    switchActivitieshomeBusiness();
                }else if(ItemID == R.id.menuCharge){
                    switchActivitieshomeCharge();
                }else if(ItemID == R.id.menuClient){
                    switchActivitieshomeClient();
                }else if(ItemID == R.id.menuCurrency){
                    switchActivitieshomeCurrency();
                }else if(ItemID == R.id.menuService){
                    switchActivitieshomeService();
                }else if(ItemID == R.id.menuSettings){
                    switchActivitieshomeSettings();
                }else if(ItemID == R.id.menuUser){
                    switchActivitieshomeUser();
                }

                return false;
            }
        });

        DB_User = new User(homeUser.this);

        TextView firstname_value = (TextView) findViewById(R.id.firstnameValue);
        firstname_value.setText(getFirstName());
        TextView lastname_value = (TextView) findViewById(R.id.lastnameValue);
        lastname_value.setText(getLastName());
        TextView treasury_value = (TextView) findViewById(R.id.sirenValue);
        treasury_value.setText(getSIREN());
        TextView siret_value = (TextView) findViewById(R.id.siretValue);
        siret_value.setText(getSIRET());
        TextView date_value = (TextView) findViewById(R.id.dateValue);
        date_value.setText(getDate());
        TextView taxation_value = (TextView) findViewById(R.id.taxationValue);
        taxation_value.setText(getTaxation());
        TextView identifier_value = (TextView) findViewById(R.id.identifierValue);
        identifier_value.setText(getIdentifier());
        TextView email_value = (TextView) findViewById(R.id.emailValue);
        email_value.setText(getEmail());
        TextView phone_value = (TextView) findViewById(R.id.phoneValue);
        phone_value.setText(getPhone());

    }

    protected String getSIREN(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            SIREN = cursor.getString(3);
        }
        return SIREN;

    }

    protected String getSIRET(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            SIRET = cursor.getString(4);
        }
        return SIRET;

    }

    protected String getDate(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            date = cursor.getString(5);
        }
        return date;

    }

    protected String getTaxation(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            taxation = cursor.getString(6);
        }
        return taxation;

    }

    protected String getFirstName(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            first_name = cursor.getString(7);
        }
        return first_name;

    }

    protected String getLastName(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            last_name = cursor.getString(8);
        }
        return last_name;

    }

    protected String getIdentifier(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            identifier = cursor.getString(9);
        }
        return identifier;

    }

    protected String getEmail(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            email = cursor.getString(10);
        }
        return email;

    }

    protected String getPhone(){
        Cursor cursor = DB_User.readData();
        while (cursor.moveToNext()){
            phone = cursor.getString(12);
        }
        return phone;

    }

    public void switchActivitiesHome(){
        Intent switchActivityIntent = new Intent(this, homeMenu.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitiesBank(){
        Intent switchActivityIntent = new Intent(this, homeBank.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeBusiness(){
        Intent switchActivityIntent = new Intent(this, homeBusiness.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeCharge(){
        Intent switchActivityIntent = new Intent(this, homeCharge.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeClient(){
        Intent switchActivityIntent = new Intent(this, homeClient.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeCurrency(){
        Intent switchActivityIntent = new Intent(this, homeCurrency.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeService(){
        Intent switchActivityIntent = new Intent(this, homeService.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeSettings(){
        Intent switchActivityIntent = new Intent(this, homeSettings.class);
        startActivity(switchActivityIntent);
    }

    public void switchActivitieshomeUser(){
        Intent switchActivityIntent = new Intent(this, homeUser.class);
        startActivity(switchActivityIntent);
    }

}
