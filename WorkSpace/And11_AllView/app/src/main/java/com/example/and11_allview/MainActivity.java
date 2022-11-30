package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.and11_allview.listfrag.ListFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_sub, btn_listf, btn_grid, btn_recycler;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sub = findViewById(R.id.btn_sub);
        btn_listf = findViewById(R.id.btn_listf);
        btn_grid = findViewById(R.id.btn_grid);
        btn_recycler = findViewById(R.id.btn_recycler);

        btn_sub.setOnClickListener(this);
        btn_listf.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == R.id.btn_sub ){
            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            startActivity(intent);
        } else if(v.getId() == R.id.btn_listf){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ListFragment()).commit();
            //container 자동완성안되는거 생각하기
        }

    }
}