package com.freelanceaccounting.emile.ovh.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.freelanceaccounting.emile.ovh.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class homeBusiness extends AppCompatActivity{

    FloatingActionButton addBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_business);

        addBusiness = findViewById(R.id.addBusiness);

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

        addBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivitiesaddBusiness();
            }
        });

    }

    public void switchActivitiesaddBusiness(){
        Intent switchActivityIntent = new Intent(this, addBusiness.class);
        startActivity(switchActivityIntent);
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
