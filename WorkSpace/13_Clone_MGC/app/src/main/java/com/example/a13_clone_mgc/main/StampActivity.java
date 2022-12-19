package com.example.a13_clone_mgc.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a13_clone_mgc.R;

public class StampActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stamp);

        getSupportActionBar().hide();

        ImageView iv_refresh,iv_left;
        TextView tv_stamp_history;

        iv_refresh=findViewById(R.id.iv_refresh);
        iv_left=findViewById(R.id.iv_left);
        tv_stamp_history=findViewById(R.id.tv_stamp_history);

        iv_refresh.setOnClickListener(this);
        iv_left.setOnClickListener(this);
        tv_stamp_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.iv_refresh){
            //새로고침
            finish();
            overridePendingTransition(0, 0);
            Intent intent = getIntent();
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else if(v.getId() == R.id.iv_left){
            finish();
            overridePendingTransition(R.anim.out_from_left,R.anim.out_to_right);
        } else if(v.getId()==R.id.tv_stamp_history){
            Intent intent = new Intent(StampActivity.this,StampHistoryActivity.class);
            startActivity(intent);

            overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        }
    }
}