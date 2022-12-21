package com.example.lastproject.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {

    Button btn_test1, btn_test2, btn_test3, btn_test4, btn_test5;
    final String TAG = "로그";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        ApiClient.setBASEURL("http://192.168.0.15/middle/");

        btn_test1 = findViewById(R.id.btn_test1);
        btn_test2 = findViewById(R.id.btn_test2);
        btn_test3 = findViewById(R.id.btn_test3);
        btn_test4 = findViewById(R.id.btn_test4);
        btn_test5 = findViewById(R.id.btn_test5);

        btn_test1.setOnClickListener(v -> { new CommonMethod().sendPost("test1",(isResult, data) ->
                Log.d(TAG, "onCreate: 람다식 ㅎㅇ ")); });
        btn_test2.setOnClickListener(v -> {
            new CommonMethod().setParams("str", "첫번째").setParams("intval","123")
                    .setParams("dval", "123.00").sendPost("test2", new CommonMethod.CallbackResult() {
                        @Override
                        public void result(boolean isResult, String data) {
                            if(isResult)
                                 Log.d(TAG, "result: 전송완료");
                        }
                    });
        });
        btn_test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().sendPost("test3", new CommonMethod.CallbackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        Log.d(TAG, "result: "+data);
                    }
                });
            }
        });
        btn_test4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().sendPost("test4", new CommonMethod.CallbackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        ExamVO vo  = new Gson().fromJson(data,ExamVO.class);
                        Log.d(TAG, "result: "+vo.getiVal());
                        Log.d(TAG, "result: "+vo.getsVal());
                        Log.d(TAG, "result: "+vo.getdVal());
                    }
                });
            }
        });

        btn_test5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("no","3").sendPost("test5", new CommonMethod.CallbackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        Log.d(TAG, "result: "+data);
                        //TypeToken typeToken= new TypeToken();
                        ArrayList<ExamVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<ExamVO>>(){}.getType());
                        Log.d(TAG, "result: "+ list.size());
                    }
                });
            }
        });

    }
}