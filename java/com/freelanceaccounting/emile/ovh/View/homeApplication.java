package com.freelanceaccounting.emile.ovh.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.PopupMenu;

import com.freelanceaccounting.emile.ovh.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.freelanceaccounting.emile.ovh.databinding.HomeApplicationBinding;

/**
     * homeApplication class.
     *
     * @author Emile Z.
     */

public class homeApplication extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private HomeApplicationBinding binding;

    Button action_settings;
    Button action_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomeApplicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHomeApplication.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_bank, R.id.nav_business, R.id.nav_charge, R.id.nav_client, R.id.nav_currency, R.id.nav_service)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_application);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_application, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_application);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void switchActivitiessettingsApplication(){
        Intent switchActivityIntent = new Intent(this, settingApplication.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivitiesuserApplication(){
        Intent switchActivityIntent = new Intent(this, userApplication.class);
        startActivity(switchActivityIntent);
    }
}