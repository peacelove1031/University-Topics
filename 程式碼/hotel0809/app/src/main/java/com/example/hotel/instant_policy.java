package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instant_policy extends AppCompatActivity implements View.OnClickListener{
    private Intent intent_policy;
    private Button backEnv,policy_1,policy_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_policy);
        backEnv = findViewById(R.id.BtBackEnv);
        policy_1 = findViewById(R.id.policy_title_1);

        backEnv.setOnClickListener(this);
        policy_1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtBackEnv:
                finish();
                break;
            case R.id.policy_title_1:
                intent_policy = new Intent(this,instant_policy_post1.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(intent_policy);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}