package com.example.prezziemobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.prezziemobile.R;
import com.example.prezziemobile.sql.DatabaseHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    private AppCompatActivity activity = MainActivity.this;
    private DrawerLayout drawer;
    private AppCompatTextView textViewUsernameHeader;
    private AppCompatTextView textViewEmailHeader;
    private AppCompatButton buttonLogout;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initViews();
        //initObjects();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        textViewEmailHeader = headerView.findViewById(R.id.textViewEmailHeader);
        textViewUsernameHeader = headerView.findViewById(R.id.textViewUsernameHeader);
        buttonLogout = headerView.findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_close, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AllRequestsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_allrequests);
        }

        /*Intent intent = getIntent();
        String usernameFromIntent = intent.getStringExtra("USERNAME");
        textViewUsernameHeader.setText(usernameFromIntent);
        String emailFromIntent = intent.getStringExtra("EMAIL");
        textViewEmailHeader.setText(emailFromIntent);*/

        SharedPreferences loginData = getSharedPreferences("logindata", Context.MODE_PRIVATE);

        textViewUsernameHeader.setText(loginData.getString("username", "Peter Lustig"));
        textViewEmailHeader.setText(loginData.getString("email", "peter.lustig@gmail.com"));



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_allrequests:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AllRequestsFragment()).commit();
                break;
            case R.id.nav_myrequests:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyRequestsFragment()).commit();
                break;
            case R.id.nav_addrequests:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddRequestFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HelpFragment()).commit();
                break;
            case R.id.nav_aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutUsFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogout:
                SharedPreferences logoutpref = getSharedPreferences("logintesting", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = logoutpref.edit();
                editor.remove("isLoggedIn");
                editor.commit();

                finish();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }

    }



    /*public void initViews(){

        textViewUsernameHeader = findViewById(R.id.textViewUsernameHeader);
        textViewEmailHeader = findViewById(R.id.textViewEmailHeader);
    }*/

//    public void initObjects(){
//
//        //textViewUsernameHeader.setText("Peter");
//
//        Intent intent = getIntent();
//        //String usernameFromIntent = intent.getStringExtra("USERNAME");
//        //textViewUsernameHeader.setText(usernameFromIntent);
//        String emailFromIntent = intent.getStringExtra("EMAIL");
//        textViewEmailHeader.setText(emailFromIntent);
//    }
}
