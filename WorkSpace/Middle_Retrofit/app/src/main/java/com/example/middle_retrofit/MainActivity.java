package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.middle_retrofit.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // 위젯을 하나씩 find안해도 하나로 묶어놓음
final String TAG="로그";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //바인딩 한번에 가능.

        binding.tv.setText("애도 안되는데?");
        CommonMethod cm = new CommonMethod();
        cm.setParams("data","얄루");
        cm.getData("andVo", new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                binding.tv.setText("뭐꼬"); //애 왜 안됨????????
                Log.d(TAG, "onResponse: "+response.body());
                CustomerVO vo = new Gson().fromJson(response.body(),CustomerVO.class);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

}