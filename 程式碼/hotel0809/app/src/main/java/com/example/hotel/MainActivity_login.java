package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity_login extends AppCompatActivity implements View.OnClickListener {
    private Button bt_login, bt_forget, bt_register;
    private TextInputLayout text_account, text_password;
    private Intent login_Intent;
    private Thread login_link_start;
    private String str_account="",str_password="";
    private Handler loginHandler;
    private HandlerThread loginHandlerThread;
    private int start_thread_count = 0;
    private httpClient loginHttpClient;
    private JSONObject loginjsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        //start Handler
        loginHandlerThread=new HandlerThread("Login");
        loginHandlerThread.start();
        loginHandler=new Handler(loginHandlerThread.getLooper());

        //find button object
        bt_login = findViewById(R.id.b_login);
        bt_forget = findViewById(R.id.b_for);
        bt_register = findViewById(R.id.b_reg);

        //find text object
        text_account = findViewById(R.id.textAccont);
        text_password = findViewById(R.id.textPassword);

        //set button of event
        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        bt_forget.setOnClickListener(this);

        login_link_start = new Thread(new Runnable() {
            @Override
            public void run() {
                String result="";
                String json ="";

                str_account=text_account.getEditText().getText().toString().trim();
                str_password=text_password.getEditText().getText().toString().trim();
                start_thread_count++;

                json="{\"account\":\""+str_account+"\",\"password\":\""+str_password+"\"}";

                //Log.e("account",str_account);
                //Log.e("password",str_password);
                //Log.e("thread_count",String.valueOf(start_thread_count));

                loginHttpClient = new httpClient();

                result=loginHttpClient.Post("Login",json);
                try {
                    loginjsonObject=new JSONObject(result);
                    result=loginjsonObject.getString("result").toString().replace("[","").replace("]","").trim().toString();
                    Log.e("Loginstate",String.valueOf(result.length()));
                    if(result.length()!=0){
                        showMessage("登入成功");
                        finish();
                    }else{
                        showMessage("登入失敗，帳號或密碼有誤");
                    }
                    loginjsonObject=new JSONObject();
                    Log.e("loginjsonObject",loginjsonObject.toString());
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
            case R.id.b_login:
                //login
                loginHandler.post(login_link_start);
                break;
            case R.id.b_for:
                //forget
                login_Intent = new Intent(this,MainActivity_login.class );
                next();
                break;
            case R.id.b_reg:
                //register
                login_Intent = new Intent(this,MainActivity_login.class );
                break;
        }

    }

    //intent
    public void next ()
    {
        startActivity(login_Intent);
    }

    //return
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(start_thread_count!=0)
            loginHandler.removeCallbacks(login_link_start);

        loginHandlerThread.quit();
        finish();
    }
    //close app
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(start_thread_count!=0)
        loginHandler.removeCallbacks(login_link_start);

        loginHandlerThread.quit();
    }
}