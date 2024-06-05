package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pass_token extends AppCompatActivity implements View.OnClickListener{
    private Button tour,door,housekeeping,entertainment;
    private Intent token_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_token);
        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tour = findViewById(R.id.tour);
        door = findViewById(R.id.door);
        housekeeping = findViewById(R.id.housekeeping);
        entertainment = findViewById(R.id.entertainment);

        tour.setOnClickListener(this);
        door.setOnClickListener(this);
        housekeeping.setOnClickListener(this);
        entertainment.setOnClickListener(this);
    }
        //button of event
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tour:
                    token_Intent = new Intent(this,pass_tour.class );
                    next();
                    break;
                case R.id.door:
                    token_Intent = new Intent(this,pass_door.class );
                    next();
                    break;
                case R.id.housekeeping:
                    token_Intent = new Intent(this,pass_house.class );
                    next();
                    break;
                case R.id.entertainment:
                    token_Intent = new Intent(this,pass_entertainment.class );
                    next();
                    break;

            }

        }

        //intent
        public void next ()
        {
            startActivity(token_Intent);
        }

        //return
        @Override
        public void onBackPressed() {
            super.onBackPressed();
            finish();
        }
}