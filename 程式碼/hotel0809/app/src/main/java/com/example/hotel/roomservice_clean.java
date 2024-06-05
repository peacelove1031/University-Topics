package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class roomservice_clean extends AppCompatActivity implements View.OnClickListener {
    private  Intent clean_Intent;
    private Button backEnv,tv_4,tv_5;
    private EditText e_reg_forget_mail;
    private Thread room_recond_link_start,room_recond_clear_start;
    private Handler room_recondHandler;
    private HandlerThread room_recondHandlerThread;
    private int start_thread_count = 0,start_clear_thread_count=0;
    private httpClient room_recondHttpClient;
    private JSONObject room_recondjsonObject;
    private String[] clear,time;
    private Spinner spinnerclear;
    private String clear_key="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomservice_clean);
        //find of component;
        backEnv = findViewById(R.id.BtBackEnv);
        tv_4 = findViewById(R.id.tv_4);
        tv_5 = findViewById(R.id.tv_5);
        e_reg_forget_mail = findViewById(R.id.e_reg_forget_mail);
        spinnerclear = (Spinner) findViewById(R.id.spinner_clear);

        backEnv.setOnClickListener(this);
        tv_4.setOnClickListener(this);
        tv_5.setOnClickListener(this);

        //start Handler
        room_recondHandlerThread=new HandlerThread("room_recond");
        room_recondHandlerThread.start();
        room_recondHandler=new Handler(room_recondHandlerThread.getLooper());
        room_recond_link_start = new Thread(new Runnable() {
            @Override
            public void run() {
                String result="";
                String json ="";
                start_thread_count++;

                json="{\"type\":\"clear_0\"}";

                //Log.e("account",str_account);
                //Log.e("password",str_password);
                //Log.e("thread_count",String.valueOf(start_thread_count));

                room_recondHttpClient = new httpClient();

                result=room_recondHttpClient.Post("RoomService",json);
                JSONArray jsonArray = null;
                JSONObject jsonObject = null;
                int clear_length = 0 ;
                try {
                    room_recondjsonObject = new JSONObject(result);
                    jsonArray = room_recondjsonObject.getJSONArray("result");
                    clear= new String[jsonArray.length()];
                    time= new String[jsonArray.length()];
                    result = room_recondjsonObject.getString("result").toString().replace("[", "").replace("]", "").trim().toString();
                    Log.e("room_recondstate", String.valueOf(result.length()));

                    if (result.length() != 0) {
                        //showMessage("查詢成功");
                        result="";
                        for( int i=0 ; i<jsonArray.length();i++){
                            jsonObject= jsonArray.getJSONObject(i);
                            time[i] =  jsonObject.getString("time");
                            clear[i]=jsonObject.getString("name");
                        }

                    } else {
                        //showMessage("查詢失敗");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
        room_recondHandler.post(room_recond_link_start);


        spinnerclear.setDropDownVerticalOffset(50);
        ArrayAdapter<CharSequence> arrayAdapterclear=ArrayAdapter.createFromResource(this,R.array.room_service_clear,R.layout.spinner_item);
        arrayAdapterclear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerclear.setAdapter(arrayAdapterclear);
        room_recond_clear_start = new Thread(new Runnable() {
            @Override
            public void run() {
                String result="";
                String json ="";
                start_clear_thread_count++;

                Date clearDate=new Date();
                SimpleDateFormat clearTime = new SimpleDateFormat();
                clearTime.applyPattern("yyyy-MM-dd HH:mm:ss");
                json="{\"sql\":\"INSERT INTO table_user_service ( id,type_key, user_id, room_id,time) VALUES ( NULL,'"+clear_key+"', '1', '1','"+clearTime.format(clearDate)+"')\"}";
                Log.e("clear_insert", json);

                room_recondHttpClient = new httpClient();

                result=room_recondHttpClient.Post("Sqlcommed",json);
                JSONArray jsonArray = null;
                JSONObject jsonObject = null;
                int clear_length = 0 ;
                try {
                    room_recondjsonObject = new JSONObject(result);
                    result = room_recondjsonObject.getString("result").toString().replace("[", "").replace("]", "").trim().toString();
                    if (result.length() != 0) {
                        showMessage("新增成功");
                        room_recondHandler.post(room_recond_link_start);
                    } else {
                        showMessage("新增失敗");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });



    }
    //alert message
    public void showMessage(String  message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    //button of event
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtBackEnv:
                finish();
                break;
            case R.id.tv_4:
                int index = spinnerclear.getSelectedItemPosition();

                //showMessage(String.valueOf(spinnerclear.getSelectedItemPosition()));
                if(index!=0){
                    clear_key="clear_0_"+index;
                    room_recondHandler.post(room_recond_clear_start);
                }else{
                    showMessage("請選擇清潔項目");
                }
                break;
            case R.id.tv_5:
                clean_Intent = new Intent(this,roomservice_clean_record.class );
                clean_Intent.putExtra("clear",clear);
                clean_Intent.putExtra("time",time);
                next();
                break;
        }

    }

    //intent
    public void next ()
    {
        startActivity(clean_Intent);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    //close app
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(start_thread_count!=0)
            room_recondHandler.removeCallbacks( room_recond_link_start);
        if(start_clear_thread_count!=0)
            room_recondHandler.removeCallbacks(room_recond_clear_start);

        room_recondHandlerThread.quit();
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}