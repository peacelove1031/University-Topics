package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class epidemic_prevention extends AppCompatActivity implements View.OnClickListener {
    private Button epidemic_requirements,epidemic_purify,epidemic_retur;
    private Intent intent_epidemic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epidemic_prevention);
        epidemic_requirements = findViewById(R.id.requirements);
        epidemic_purify = findViewById(R.id.purify);
        epidemic_retur = findViewById(R.id.retur);

        epidemic_requirements.setOnClickListener(this);
        epidemic_retur.setOnClickListener(this);
        epidemic_purify.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.requirements:
                intent_epidemic = new Intent(this,epidemic_prevention_requirements.class);
                next();
                break;
            case R.id.purify:
                intent_epidemic = new Intent(this, epidemic_prevention_purify.class);
                next();
                break;
            case R.id.retur:
                intent_epidemic = new Intent(this, epidemic_prevention_retur.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(intent_epidemic);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}