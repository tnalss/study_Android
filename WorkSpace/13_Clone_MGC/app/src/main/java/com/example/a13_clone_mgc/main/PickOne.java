package com.example.a13_clone_mgc.main;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.a13_clone_mgc.R;

public class PickOne extends Dialog {
    public PickOne(@NonNull Context context, ProductDTO productDTO) {
        super(context);
        setContentView(R.layout.dialog_pick_one);
        TextView tv_product_name,tv_product_detail;
        ImageView iv_product,iv_order,iv_send;

        Button btn_close = findViewById(R.id.btn_close);

        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_detail = findViewById(R.id.tv_product_detail);

        iv_product = findViewById(R.id.iv_product);
        iv_order = findViewById(R.id.iv_order);
        iv_send = findViewById(R.id.iv_send);

        iv_product.setImageResource(productDTO.getImageSrc());
        tv_product_name.setText(productDTO.getName());
        tv_product_detail.setText(productDTO.getDesc());

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }
}
