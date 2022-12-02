package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.and11_allview.gridv.GridFragment;
import com.example.and11_allview.listfrag.ListFragment;
import com.example.and11_allview.recycler.RecyclerFragment;
import com.example.and11_allview.recycler_melon.RecyclerMelonFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_sub, btn_listf, btn_grid, btn_recycler, btn_recycler_self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sub = findViewById(R.id.btn_sub);
        btn_listf = findViewById(R.id.btn_listf);
        btn_grid = findViewById(R.id.btn_grid);
        btn_recycler = findViewById(R.id.btn_recycler);
        btn_recycler_self=findViewById(R.id.btn_recycler_self);

        btn_sub.setOnClickListener(this);
        btn_listf.setOnClickListener(this);
        btn_grid.setOnClickListener(this);
        btn_recycler.setOnClickListener(this);
        btn_recycler_self.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == R.id.btn_sub ){
            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            startActivity(intent);
        } else if(v.getId() == R.id.btn_listf){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ListFragment()).commit();
            //container 자동완성안되는거 생각하기
        } else if ( v.getId() == R.id.btn_grid){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new GridFragment()).commit();
        } else if ( v.getId() == R.id.btn_recycler){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RecyclerFragment()).commit();
        } else if ( v.getId() == R.id.btn_recycler_self){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RecyclerMelonFragment()).commit();
        }

    }
}