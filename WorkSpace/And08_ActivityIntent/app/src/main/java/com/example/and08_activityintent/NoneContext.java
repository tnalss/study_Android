package com.example.and08_activityintent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NoneContext {
    LayoutInflater inflater;

    public NoneContext(LayoutInflater inflater){
        this.inflater=inflater;
    }

    // 메소드 하나 만들기
    public void method1(){

        if(inflater==null){
            Log.d("인플레이터", "method1: ");
        }else{
            Log.d("인플레이터", "method1: 낫널 ");
        }
    }

    public void showToast(MainActivity activity){
        Toast.makeText( activity, "토스트", Toast.LENGTH_SHORT).show();
    }
    //
    public void v1Setting(View v1){
        TextView tv_sub1= v1.findViewById(R.id.tv_sub1);
        tv_sub1.setText("v1sete");
        Button btn_sub1 = v1.findViewById(R.id.btn_sub1);
        btn_sub1.setText("asfsadf");
    }
}
