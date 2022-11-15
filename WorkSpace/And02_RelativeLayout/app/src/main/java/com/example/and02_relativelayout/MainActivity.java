package com.example.and02_relativelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //직접만드는 부분이기 때문에 new로 만들어주자.
        //context는 안드로이드에서 가장 중요한데 일단은 맥락이라고 생각
        //context(맥락): 현재화면에 보여지는 객체의 상태정보를 의미함

        Button btn = new Button(this);
        btn.setText("자바코드로 버튼 넣음");
        TextView tv = new TextView(this);
        tv.setText(" C S M  C S M  C S M  C S M  C S M  C S M  C S M  C S M ");
        //위젯(TextView1, Button x2) ==> 뷰를 split으로 보면 constraint layout속에 있다.
        //코드로 치는 경우에는 선언해서
        ConstraintLayout layout = new ConstraintLayout(this);
        //하나씩 추가해준다.
        layout.addView(tv);
        layout.addView(btn);

        //레이아웃을 출력해보자.
        setContentView(layout);
        //자바코드로 디자인 안하는 이유 미리보기가 안된다... 어렵다...
        //하는이유 버튼이 몇개필요한지 모를때 이럴때는 자바코드로 디자인을 한다.=> 우리는 xml으로 디자인을 많이할것



        //setContentView(R.layout.activity_main);

        //Object obj = null;
        // obj에 담을 수 있는 값?
        //Object는 모든 타입을 담을 수 있는 객체 (최상위)
        // 왜 변수타입을 나눠서 사용할까?
        // 변수타입마다 크기가 다름, 효율성
        //String str ="";
        //str의 기능이 훨씬 많다.


    }
}