package com.example.project01_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ProgressDialog : ※ 사용자 입장에서 중요한 UI요소 ※
        // 사용자는 현재 앱이 멈춘건지 아니면 데이터 로딩을 위해서 시간이 소요되는지.?
        // 판단을 할 수가 없음. : 빈번하게 많이 사용됨.
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("KYM TALK 데이터 로딩");
        dialog.setMessage("로딩중....");
        dialog.setCancelable(false);
        dialog.show();//<= 실제로 화면에 보이게 만드는 메소드

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();//안보이게 처리
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }, 1000);

    }
}