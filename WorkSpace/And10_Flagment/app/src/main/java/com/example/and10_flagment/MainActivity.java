package com.example.and10_flagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    // LayoutInflater 다른 뷰를 불러와서 레이 아웃에 넣어줌
    // # 붙을 공간 => ViewGroup(Layout)
    // # 붙일 내용 => .xml(Layout)
    // fragment는 반드시 LayoutInflater가 있는 상태로 붙음.
    // 반드시 액티비티 안에 있는 형태
    // 만드는 방법 : 패키지 마우스 오른쪽 클릭 후 Fragment 찾기
    // blank Fragment 생성
    Button btn_frag1,btn_frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_frag1 = findViewById(R.id.btn_frag1);
        btn_frag2 = findViewById(R.id.btn_frag2);


        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 트랜잭션?? : 이란게 일어나면 그 후 반드시 해줘야하는 것???
                // rollback,commit을 해줘야함!!!!
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainFragment()).commit();
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new SubFragment()).commit();
            }
        });

    }
}