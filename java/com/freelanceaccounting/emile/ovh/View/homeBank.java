package com.freelanceaccounting.emile.ovh.View;

import com.freelanceaccounting.emile.ovh.Class.Bank;
import com.freelanceaccounting.emile.ovh.R;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class homeBank extends AppCompatActivity{

    Bank DB_Bank;

    String treasury;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_bank);

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

        DB_Bank = new Bank(homeBank.this);

        TextView treasury_value = (TextView) findViewById(R.id.treasuryValue);
        treasury_value.setText(getTreasury());

    }

    protected String getTreasury(){
        Cursor cursor = DB_Bank.readData();
        while (cursor.moveToNext()){
            treasury = cursor.getString(6);
        }
        return treasury;
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
