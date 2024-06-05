package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class placeholder_journey_suitcase extends AppCompatActivity implements View.OnClickListener {
    private Button tv_1,tv_2,tv_3;
    private Intent placeholder_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder_journey_suitcase);
        tv_1 = findViewById(R.id.travel_1);
        tv_2 = findViewById(R.id.travel_2);
        tv_3 = findViewById(R.id.travel_3);

        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.travel_1:
                placeholder_Intent = new Intent(this,placeholder_journey_farm.class);
                next();
                break;
            case R.id.travel_2:
                placeholder_Intent = new Intent(this,placeholder_journey_zhao.class);
                next();
                break;
            case R.id.travel_3:
                placeholder_Intent = new Intent(this,placeholder_journey_spring.class);
                next();
                break;

        }
    }
    //intent
    public void next ()
    {
        startActivity(placeholder_Intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}