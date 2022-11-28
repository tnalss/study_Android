package com.example.and09_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //p.249 액티비티 수명주기
    //activity를 상속받았기 때문에 수명주기가 적용됨
    Button btn;
    final String TAG="수명주기";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

    }
    
    //재정의 (기존기능 + 기능 , 형태는 같으나 내부를 완전히 바꿈) 오버라이드
    @Override
    protected void onStart() {
        super.onStart();
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this , SubActivity.class);
        startActivity(intent);
    }
}