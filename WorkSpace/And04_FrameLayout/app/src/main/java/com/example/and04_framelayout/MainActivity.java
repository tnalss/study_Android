package com.example.and04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button prev,next;
    ArrayList<ImageView> img = new ArrayList<ImageView>();

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prev = findViewById(R.id.btn1);
        next = findViewById(R.id.btn2);

        img.add(findViewById(R.id.imgv1));
        img.add(findViewById(R.id.imgv2));
        img.add(findViewById(R.id.imgv3));

        prev.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    public void imgChange(){
        for(ImageView each : img){
            each.setVisibility(View.GONE);
        }
        img.get(count).setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1) {
            count--;
            if(count==-1) count=2;
            imgChange();
        }else if(v.getId()==R.id.btn2){
            count++;
            if(count==3 ) count=0;
            imgChange();
        }
    }
}