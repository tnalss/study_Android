package com.example.a13_clone_mgc.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a13_clone_mgc.R;
import com.google.android.material.tabs.TabLayout;

public class StampHistoryActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stamp_history);
        getSupportActionBar().hide();

        TabLayout tb_period;
        ImageView iv_left;
        RecyclerView recv_history;

        tb_period = findViewById(R.id.tb_period);
        iv_left = findViewById(R.id.iv_left);
        recv_history = findViewById(R.id.recv_history);
        recv_history.setAdapter(new HistoryAdapter(getLayoutInflater(),StampHistoryActivity.this));
        recv_history.setLayoutManager(new LinearLayoutManager(StampHistoryActivity.this,LinearLayoutManager.VERTICAL,false));

        iv_left.setOnClickListener(this);

        tb_period.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    //일주일 기간
                    recv_history.setAdapter(new HistoryAdapter(getLayoutInflater(),StampHistoryActivity.this));
                    recv_history.setLayoutManager(new LinearLayoutManager(StampHistoryActivity.this,LinearLayoutManager.VERTICAL,false));

                } else if(tab.getPosition()==1){
                    //1개월 기간
                    recv_history.setAdapter(new HistoryAdapter(getLayoutInflater(),StampHistoryActivity.this));
                    recv_history.setLayoutManager(new LinearLayoutManager(StampHistoryActivity.this,LinearLayoutManager.VERTICAL,false));

                } else if(tab.getPosition()==2){
                    //3개월 기간

                } else if (tab.getPosition()==3){
                    //전체 기간
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.iv_left ){
            finish();
            overridePendingTransition(R.anim.out_from_left,R.anim.out_to_right);
        }
    }
}