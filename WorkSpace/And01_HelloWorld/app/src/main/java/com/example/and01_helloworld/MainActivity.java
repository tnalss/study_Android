package com.example.and01_helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Observer <= : 관찰자, 감시자
    // Observer Pattern : 인터페이스를 활용해서 각종 위젯의 변경상태를 감지해서 개발자에게 알려주는 형식

    //버튼위젯 찾아주기
    //xml에서 열린 태그는 반드시(대부분) 자바의 객체로 존재한다.
    //ConstraintLayout , Button
    Button btn; // <= null일까 디자인에 있는 버튼일까? => 어떤객체를 선언만 한 상태

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml이랑 자바코드를 연결해주는 메소드!

        btn = findViewById(R.id.btn); //new를 사용안함 디자인에 있는 위젯을 찾아 연결해주는 초기화식

        // 문제 ) View.OnClickListener 인터페이스를 파라미터로 넘겨보시오.
//첫번째 방식.. 인터페이스를 new로 바로 파라미터로 넘기는 방식
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        /*=========================================================================*/

//        //두번째방식 인터페이스를 미리 생성해놓고 사용하는방식
//        View.OnClickListener clickListner = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//            }
//        };
//        btn.setOnClickListener(clickListner);
//
        //=================================
        //3.상속을 받아서 나자신을 이용하는 방식
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    //여기선 syso사용하지않음 logd를 사용한다.
        Log.d("최수민", "버튼이 클릭 됨");
        for(int i =0 ; i<=50 ; i ++){
            if(i % 2 != 0)
                Log.d("최수민", i+"");
        }
    }
}