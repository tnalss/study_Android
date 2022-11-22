package com.example.additional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    ArrayList<ImageView> list = new ArrayList<>();
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        list.add(findViewById(R.id.img1));
        list.add(findViewById(R.id.img2));

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        for(ImageView vi : list){
            vi.setVisibility(View.GONE);
        }
        cnt++;
        if(cnt==2) cnt=0;
        list.get(cnt).setVisibility(View.VISIBLE);
    }

}