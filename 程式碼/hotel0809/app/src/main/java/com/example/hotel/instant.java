package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instant extends AppCompatActivity implements View.OnClickListener{
    private Button instant_healthy,instant_partner,instant_sale,instant_policy;
    private Intent intent_instant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant);

        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        instant_healthy = findViewById(R.id.instant_healthy);
        instant_partner = findViewById(R.id.instant_partner);
        instant_sale = findViewById(R.id.instant_sale);
        instant_policy = findViewById(R.id.instant_policy);

        instant_healthy.setOnClickListener(this);
        instant_partner.setOnClickListener(this);
        instant_sale.setOnClickListener(this);
        instant_policy.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.instant_healthy:
                intent_instant = new Intent(this,instant_healthy_post.class );
                next();
                break;
            case R.id.instant_partner:
                intent_instant = new Intent(this, instant_partner.class);
                next();
                break;
            case R.id.instant_sale:
                intent_instant = new Intent(this, instant_sale.class);
                next();
                break;
            case R.id.instant_policy:
                intent_instant = new Intent(this, instant_policy.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(intent_instant);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}