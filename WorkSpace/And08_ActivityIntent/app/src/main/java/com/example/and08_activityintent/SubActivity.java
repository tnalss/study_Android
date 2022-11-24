package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();//MainActivity에서 intent를 받아올 수 있다.
        String sVal = intent.getStringExtra("sVal");
        int iVal = intent.getIntExtra("iVal",-1);
        //int는 null을 사용못하기 때문에 기본으로 담을 값을.
        Log.d("로그", "onCreate: "+sVal);
        Log.d("로그", "onCreate: "+iVal);
        MemberDTO dto = (MemberDTO) intent.getSerializableExtra("dto");
        Log.d("로그", "onCreate: "+ dto.getName());

        ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) intent.getSerializableExtra("list");
        Log.d("로그", "onCreate: "+ list.size());

    }
}