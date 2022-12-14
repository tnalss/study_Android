package com.example.a13_clone_mgc.card;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a13_clone_mgc.R;
import com.ramotion.foldingcell.FoldingCell;

public class CardFragment extends Fragment {
    LinearLayout ln_careful,ln_careful_detail, ln_refund,ln_refund_detail;
    ImageView iv_careful_up,iv_careful_down,iv_refund_up,iv_refund_down;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_card, container, false);

        ln_careful = v.findViewById(R.id.ln_careful);
        ln_careful_detail = v.findViewById(R.id.ln_careful_detail);
        ln_refund = v.findViewById(R.id.ln_refund);
        ln_refund_detail = v.findViewById(R.id.ln_refund_detail);

        iv_careful_up = v.findViewById(R.id.iv_careful_up);
        iv_careful_down = v.findViewById(R.id.iv_careful_down);
        iv_refund_up = v.findViewById(R.id.iv_refund_up);
        iv_refund_down = v.findViewById(R.id.iv_refund_down);

        ln_careful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(  iv_careful_up.getVisibility() == View.GONE ){
                    iv_careful_up.setVisibility(View.VISIBLE);
                    iv_careful_down.setVisibility(View.GONE);
                    ln_careful_detail.setVisibility(View.VISIBLE);
                }
                else{
                    iv_careful_down.setVisibility(View.VISIBLE);
                    iv_careful_up.setVisibility(View.GONE);
                    ln_careful_detail.setVisibility(View.GONE);
                }
            }
        });

        ln_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(  iv_refund_up.getVisibility() == View.GONE ){
                    iv_refund_up.setVisibility(View.VISIBLE);
                    iv_refund_down.setVisibility(View.GONE);
                    ln_refund_detail.setVisibility(View.VISIBLE);
                }
                else{
                    iv_refund_down.setVisibility(View.VISIBLE);
                    iv_refund_up.setVisibility(View.GONE);
                    ln_refund_detail.setVisibility(View.GONE);
                }
            }
        });


        return v;
    }
}