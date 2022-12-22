package com.example.a13_clone_mgc.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a13_clone_mgc.MainActivity;
import com.example.a13_clone_mgc.R;
import com.example.a13_clone_mgc.databinding.ActivityMainBinding;
import com.example.a13_clone_mgc.databinding.ActivitySendNowBinding;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class SendNowActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySendNowBinding binding; //액티비티 바인딩 체크 1
    int i= 1;
    ProductDTO dto;
    DecimalFormat df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendNowBinding.inflate(getLayoutInflater()); // 바인딩 체크 2
        setContentView(binding.getRoot()); //바인딩 하려면 이것도 반드시 해야함 // 바인딩 체크 3
        getSupportActionBar().hide();

        Intent intent = getIntent();
        dto = (ProductDTO) intent.getSerializableExtra("dto");
        df = new DecimalFormat("#,##0원");

        binding.ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.out_from_left,R.anim.out_to_right);
            }
        });
        binding.ivProduct.setImageResource(dto.getImageSrc()); //바인딩 사용방법
        binding.tvProductName.setText(dto.getName());
        binding.tvProductDetail.setText(dto.getDesc());
        binding.tvProductPrice.setText(df.format(dto.getPrice()));
        binding.tvTotal.setText(df.format(dto.getPrice()));


        binding.ivMinus.setOnClickListener(this);
        binding.ivPlus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_minus){
            if(!(i<=1)) {
                i -= 1;
                binding.tvQty.setText(i+"");
                binding.tvTotal.setText(df.format(i*dto.getPrice()));
            } else {
                i=1;
            }
        } else if(v.getId() == R.id.iv_plus){
            i += 1;
            binding.tvQty.setText(i+"");
            binding.tvTotal.setText(df.format(i*dto.getPrice()));
        }
    }
}