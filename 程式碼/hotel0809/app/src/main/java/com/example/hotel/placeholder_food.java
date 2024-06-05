package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class placeholder_food extends AppCompatActivity implements View.OnClickListener  {
    private Button tv_1,tv_2;
    private Intent placeholder_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder_food);

        tv_1 = findViewById(R.id.food_1);
        tv_2 = findViewById(R.id.food_2);
        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.food_1:
                placeholder_Intent = new Intent(this,placeholder_food_wu.class);
                next();
                break;
            case R.id.food_2:
                placeholder_Intent = new Intent(this,placeholder_food_porridge.class);
                next();
                break;

        }
    }
    //intent
    public void next ()
    {
        startActivity(placeholder_Intent);
    }
}