package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class callus_service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callus_service);
        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button bt_finish = findViewById(R.id.BtCheckUsQuestion);
        bt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("謝謝您提供的意見");finish();
            }
        });

        Spinner spinner = findViewById(R.id.SpinnerQuestionSort);
        Spinner spinner2 = findViewById(R.id.SpinnerQuestionItem);

        spinner.setDropDownVerticalOffset(50);
        ArrayAdapter<CharSequence> arrayAdapterclear=ArrayAdapter.createFromResource(this,R.array.custom_center_object,R.layout.spinner_item);
        arrayAdapterclear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapterclear);


        spinner2.setDropDownVerticalOffset(50);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.custom_center,R.layout.spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter);


    }
    //alert message
    public void showMessage(String  message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}