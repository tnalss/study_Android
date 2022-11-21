package com.example.and05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView tv;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        btn.setOnClickListener(this);
        for(int i =0 ; i<=10 ; i++) {
            tv.append("안녕하세요안녕하세요안녕하세요안녕하세요");
            tv.append("\n안녕하세요"+i);
        }
    }

    @Override
    public void onClick(View v) {
        tv.setText("");
    }
}