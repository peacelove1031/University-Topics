package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instant_healthy_post extends AppCompatActivity implements View.OnClickListener {
    private Button backEnv,healthy_post_1;
    private Intent intent_instant_healthy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_healthy_post);
        backEnv = findViewById(R.id.BtBackEnv);
        healthy_post_1 = findViewById(R.id.healthy_title_1);


        backEnv.setOnClickListener(this);
        healthy_post_1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtBackEnv:
                finish();
                break;
            case R.id.healthy_title_1:
                intent_instant_healthy = new Intent(this,instant_healthy_post1.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(intent_instant_healthy);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}