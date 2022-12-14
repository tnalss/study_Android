package com.example.a13_clone_mgc.main;

import android.app.Dialog;
import android.content.Context;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.a13_clone_mgc.MainActivity;
import com.example.a13_clone_mgc.R;

public class PickOne extends Dialog {

    MainFragment mainFragment;

    public PickOne(@NonNull Context context, ProductDTO productDTO , MainFragment mainFragment) {
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

        iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                MainActivity activity = (MainActivity) mainFragment.getActivity();
                activity.btm_nav.setSelectedItemId(R.id.btm_item3);

            }
        });

        iv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) mainFragment.getActivity();
                Intent intent = new Intent(getContext(),SendNowActivity.class);
                intent.putExtra("dto",productDTO);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
            }
        });
    }


}
