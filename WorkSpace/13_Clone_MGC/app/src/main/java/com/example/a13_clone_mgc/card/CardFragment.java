package com.example.a13_clone_mgc.card;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a13_clone_mgc.R;

public class CardFragment extends Fragment implements View.OnClickListener {
    LinearLayout ln_careful,ln_careful_detail, ln_refund,ln_refund_detail;
    ImageView iv_careful_up,iv_careful_down,iv_refund_up,iv_refund_down,iv_refresh;
    TextView tv_refund_detail;
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
        iv_refresh = v.findViewById(R.id.iv_refresh);

        tv_refund_detail = v.findViewById(R.id.tv_refund_detail);

        ln_careful.setOnClickListener(this);
        ln_refund.setOnClickListener(this);
        iv_refresh.setOnClickListener(this);

        SpannableStringBuilder sp = new SpannableStringBuilder("5. 매장에서는 잔액 환불이 불가합니다. 환불 관련 문의는 고객센터 1:1 문의남기기 혹은 카카오톡채널(ID:발투르스트)로 문의해주세요. (운영시간 평일 10:00~17:00 , 점심시간 12:00~13:00 / 주말 및 공휴일 휴무)");
        sp.setSpan(new UnderlineSpan(),33,47, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.BLUE),33,47, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sp.setSpan(new UnderlineSpan(),51,71, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.BLUE),51,71, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.RED),85,116, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        tv_refund_detail.setText(sp);

        return v;
    }

    @Override
    public void onClick(View v) {
        if( v.getId() == R.id.ln_refund ){
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
        } else if(v.getId() == R.id.ln_careful){
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
        } else if(v.getId() == R.id.iv_refresh){
            Toast.makeText(getContext(), "프래그먼트 새로고침 어떻게?", Toast.LENGTH_SHORT).show();
            //getChildFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}