package com.example.lastproject.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.example.lastproject.exam.ExamVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {
    RecyclerView recv_container;
    final String TAG = "로그";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getSupportActionBar().hide();

        ApiClient.setBASEURL("http://192.168.0.15/middle/");
        recv_container = findViewById(R.id.recv_container);

        selectList();

    }

    public void selectList(){
        new CommonMethod().sendPost("list.cu", new CommonMethod.CallbackResult() {
            @Override
            public void result(boolean isResult, String data) {
                Log.d(TAG, "result:" + data);
                ArrayList<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
                //비동기영역 result는 최대 10초 후에 실행될 수 있음
                recv_container.setAdapter(new CustomerAdapter(getLayoutInflater(),list,CustomerActivity.this));
                recv_container.setLayoutManager(new LinearLayoutManager(CustomerActivity.this,RecyclerView.VERTICAL,false));
            }
        });
        Log.d(TAG, "onCreate: 비동기보다빠른가.");
    }
}