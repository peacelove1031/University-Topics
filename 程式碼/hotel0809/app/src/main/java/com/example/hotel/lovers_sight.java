package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lovers_sight extends AppCompatActivity {

    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovers_sight);
        mTv1 = (TextView)findViewById(R.id.travel_1);
        mTv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTv2 = (TextView)findViewById(R.id.travel_2);
        mTv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTv3 = (TextView)findViewById(R.id.travel_3);
        mTv3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}