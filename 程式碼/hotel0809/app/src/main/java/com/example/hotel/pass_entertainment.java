package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class pass_entertainment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_entertainment);

        Button bt_back = findViewById(R.id.BtBackEnv);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView thisisimg = (ImageView) findViewById(R.id.gameqrcode);
        BarcodeEncoder encoder = new BarcodeEncoder();


        Bitmap bit = null;
        try {
            bit = encoder.encodeBitmap("jlkdjslfjsdalfjla", BarcodeFormat.QR_CODE,
                    250, 250);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        thisisimg .setImageBitmap(bit);
    }
}