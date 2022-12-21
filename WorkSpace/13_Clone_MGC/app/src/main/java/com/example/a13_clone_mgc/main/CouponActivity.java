package com.example.a13_clone_mgc.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a13_clone_mgc.R;

public class CouponActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        getSupportActionBar().hide();

        ImageView iv_left;
        iv_left = findViewById(R.id.iv_left);

        iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.out_from_left,R.anim.out_to_right);
            }
        });

    }
}