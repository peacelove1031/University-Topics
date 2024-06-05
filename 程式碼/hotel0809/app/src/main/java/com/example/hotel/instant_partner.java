package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instant_partner extends AppCompatActivity implements View.OnClickListener{
    private  Intent intent_partner;
    private Button backEnv,partner_1,partner_2,partner_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_partner);

        backEnv = findViewById(R.id.BtBackEnv);
        partner_1 = findViewById(R.id.partner_1);
        partner_2 = findViewById(R.id.partner_2);
        partner_3 = findViewById(R.id.partner_3);

        backEnv.setOnClickListener(this);
        partner_1.setOnClickListener(this);
        partner_2.setOnClickListener(this);
        partner_3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtBackEnv:
                finish();
                break;
            case R.id.partner_1:
                intent_partner = new Intent(this,instant_partner_company1.class);
                next();
                break;
            case R.id.partner_2:
                intent_partner = new Intent(this,instant_partner_company2.class);
                next();
                break;
            case R.id.partner_3:
                intent_partner = new Intent(this,instant_partner_company3.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(intent_partner);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}