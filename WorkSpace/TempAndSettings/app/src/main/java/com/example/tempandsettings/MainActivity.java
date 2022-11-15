package com.example.tempandsettings;
//패키지

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
//임포트

public class MainActivity extends AppCompatActivity {
//AppComapatActivity를 상속받은 MainActivity 클래스
    @Override//AppCompatActivity의 onCreate를 오버라이드
    //오버라이드 : 재정의. 이미 구현되어있는 부모클래스 내용을 다시 정의해서 쓰는것
    //오버로딩 : 메소드의 이름은 같지만 파라미터 타입이나 개수를 개수가 다른 매개변수 받을 수 있음
    protected void onCreate(Bundle savedInstanceState) {
        //protected = 상속을 받아야지만 재정의를 허용함
        // // 접근제한자 protected(같은패키지, 자식) Bundle savedInstanceState를 파라미터로 받아 쓰는 onCreate 메소드 선언
        super.onCreate(savedInstanceState);
        //부모의 Oncreate 메소드 호출
        setContentView(R.layout.activity_main);
        // R의 레이아웃의 activity_main을 매개변수로 setContentView 메소드 호출

        Test t = new Test();
        //인스턴스접근을 위한 인스턴스 생성
        t.iV1=10;
        t.iV2=20;
        t.iMethod();
        // 인스턴스 접근

        Test.sV1=10;
        Test.sV2=20;
        Test.sMethod();
        // 스태틱 접근

        Test.Sub s = t.new Sub();
        s.sub_v1="hello";
        s.subMethod();
/////////////////////////////////////////////////

        Test.sSub.subV2=1;
        Test.sSub.subMethod2();
        //static 접근

        Test.sSub ss= new Test.sSub();
        ss.subV1="hi";
        ss.subMethod();
        //인스턴스 접근

        t.lMethod();


    }
}