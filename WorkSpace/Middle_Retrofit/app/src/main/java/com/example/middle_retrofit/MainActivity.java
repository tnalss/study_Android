package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        HashMap<String, Object> params = new HashMap<>();

        params.put("id","admin");
        Call<String> apiTest = apiInterface.getData("andTest",params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", "onResponse: ");

            }
        });

    }
}