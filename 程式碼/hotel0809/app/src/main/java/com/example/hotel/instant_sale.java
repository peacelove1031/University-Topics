package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instant_sale extends AppCompatActivity implements View.OnClickListener{
    private Intent intent_sale;
    private Button backEnv,sale_1,sale_2,sale_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_sale);
        backEnv = findViewById(R.id.BtBackEnv);
        sale_1 = findViewById(R.id.sale_1);
        sale_2 = findViewById(R.id.sale_2);
        sale_3 = findViewById(R.id.sale_3);

        backEnv.setOnClickListener(this);

        sale_1.setOnClickListener(this);
        sale_2.setOnClickListener(this);
        sale_3.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sale_1:
                intent_sale = new Intent(this,instant_sale_company1.class);
                next();
                break;
            case R.id.sale_2:
                intent_sale = new Intent(this,instant_sale_company2.class);
                next();
                break;
            case R.id.sale_3:
                intent_sale = new Intent(this,instant_sale_company3.class);
                next();
                break;
            case R.id.BtBackEnv:
                finish();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(intent_sale);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}