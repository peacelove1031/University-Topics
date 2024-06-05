package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class roomservice extends AppCompatActivity implements View.OnClickListener {
    private Button clear,food,callout,bus;
    private Intent roomservice_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomservice);
        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clear = findViewById(R.id.clear);
        food = findViewById(R.id.food);
        callout = findViewById(R.id.callout);
        bus = findViewById(R.id.bus);

        clear.setOnClickListener(this);
        food.setOnClickListener(this);
        callout.setOnClickListener(this);
        bus.setOnClickListener(this);

    }

    //button of event
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
                roomservice_Intent = new Intent(this,roomservice_clean.class );
                next();
                break;
            case R.id.food:
                roomservice_Intent = new Intent(this,roomservice_food.class );
                next();
                break;
            case R.id.callout:
                roomservice_Intent = new Intent(this,roomservice_callout.class );
                next();
                break;
            case R.id.bus:
                roomservice_Intent = new Intent(this,roomservice_bus.class );
                next();
                break;

        }

    }

    //intent
    public void next ()
    {
        startActivity(roomservice_Intent);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}