package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class roomservice_callout extends AppCompatActivity implements View.OnClickListener {
    private Intent room_recond_Intent;
    private String[] clear,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomservice_callout);
        room_recond_Intent =getIntent();
        clear = new String[]{"XXX","XX0"};
        time = new  String[]{"2022/8/12 下午 04:41:14","2022/8/12 下午 04:41:14"};
        ListView clear_recond_list=findViewById(R.id.clear_recond_list);
        roomservicerecordAdapter roomservicerecordAdapter_Listview=new roomservicerecordAdapter(this);
        clear_recond_list.setAdapter(roomservicerecordAdapter_Listview);


        Button room_recond_back = findViewById(R.id.BtBackEnv);
        room_recond_back.setOnClickListener(this);





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
                //login
                finish();
                break;

        }

    }

    private class roomservicerecordAdapter extends BaseAdapter {
        private LayoutInflater myInflater;
        public roomservicerecordAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount(){
            return clear.length;
        }
        @Override
        public Object getItem(int position){
            return clear[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView = myInflater.inflate(R.layout.activity_roomservice_clean_record_listview, null);

            TextView cleartype = ((TextView) convertView.findViewById(R.id.type));
            TextView cleartime = ((TextView) convertView.findViewById(R.id.time));

            // 設定元件內容
            cleartype.setText(clear[position]);
            cleartime.setText(time[position]);

            return convertView;
        }
    }
    //intent
    public void next () {
        startActivity( room_recond_Intent);
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