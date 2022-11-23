package com.example.and07_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG ="로그";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakao_act); // java <=> xml 연결

        Log.d(TAG, "리소스값 : " + getString(R.string.app_version));
        Log.d(TAG, "리소스값 : " + getString(R.string.app_name));
    }
}