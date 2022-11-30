package com.example.and10_flagment;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class SubFragment extends Fragment {

    Button btn_sub;
    ImageView iv_image,iv_image2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sub, container, false);

        btn_sub=v.findViewById(R.id.btn_sub);
        iv_image = v.findViewById(R.id.iv_image);
        iv_image2 = v.findViewById(R.id.iv_image2);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iv_image2.getVisibility()== View.VISIBLE){
                    iv_image2.setVisibility(View.GONE);
                }else{
                    iv_image2.setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }
}