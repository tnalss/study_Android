package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient.setBASEURL("http://192.168.0.15/middle/");


        new CommonMethod().setParams("email","admin").setParams("pw","admin_pw")
                            .sendGet("login", new CommonMethod.CallbackResult() {
            @Override
            public void result(boolean isResult, String data) {
                if(isResult)
                  Log.d("로그", "result: "+data);
            }
        });


    }
}