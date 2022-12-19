package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.lastproject.middle.ApiClient;
import com.example.lastproject.middle.CommonMethod;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient.setBASEURL("http://192.168.0.15/middle/");


        new CommonMethod().setParams("data","얄루")
                            .sendGet("andVo", new CommonMethod.CallbackResult() {
            @Override
            public void result(boolean isResult, String data) {
                if(isResult)
                    Log.d("TAG", "result: "+data);
            }
        });


    }
}