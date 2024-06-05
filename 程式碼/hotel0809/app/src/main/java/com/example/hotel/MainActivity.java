package com.example.hotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    ImageButton login;
    private Intent Main_Intent ;
    ViewFlipper viewFlipper;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    CallusFragment callusFragment = new CallusFragment();
    JoinusFragment joinusFragment = new JoinusFragment();
    LoversFragment loversFragment = new LoversFragment();
    PlaceholderFragment placeholderFragment = new PlaceholderFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setItemIconTintList(null);


        bottomNavigationView.setOnItemSelectedListener(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main_Intent = new Intent(MainActivity.this,MainActivity_login.class);
                next();
            }
        });



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                return true;
            case R.id.callus:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,callusFragment).commit();
                return true;
            case R.id.joinus:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,joinusFragment).commit();
                return true;
            case R.id.weblove:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,loversFragment).commit();
                return true;
            case R.id.placeholder:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,placeholderFragment).commit();
                return true;
        }
        return false;
    }

    //alert message
    public void showMessage(String  message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


    //intent
    public void next ()
    {
        startActivity(Main_Intent);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
