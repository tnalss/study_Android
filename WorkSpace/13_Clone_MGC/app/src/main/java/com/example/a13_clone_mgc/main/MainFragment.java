package com.example.a13_clone_mgc.main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a13_clone_mgc.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment implements View.OnClickListener {
        int cnt=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView iv_main_banner,iv_shopping;
        ViewPager2 imgSlider;
        RecyclerView recv_suggest,recv_notice;
        TextView tv_slider_indicator;
        Timer timer;
        LinearLayout ln_coupon,ln_stamp;

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.carousel1);
        images.add(R.drawable.carousel2);
        images.add(R.drawable.carousel3);
        images.add(R.drawable.carousel4);
        images.add(R.drawable.carousel5);
        ArrayList<ProductDTO> suggestions = new ArrayList<>();
        suggestions.add(new ProductDTO( R.drawable.suggest1,3500,"스모어블랙쿠키프라페","진한 초코스무디에 바삭한 쿠키를 넣어 퐁신퐁신한 마시멜로우 잼과 함께 달콤하게 즐기는 스무디"));
        suggestions.add(new ProductDTO( R.drawable.suggest2,4000,"따끈따끈간식꾸러미","겨울에 생각나는 팥붕어빵,초코조개빵,앙버터호두과자로 구성된 따끈한 간식꾸러미"));
        suggestions.add(new ProductDTO( R.drawable.suggest3,3800,"태극전사레드불에너지","우리나라 국기의 태극 문양을 표현한 트로피컬 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        suggestions.add(new ProductDTO( R.drawable.suggest4,3700,"붉은악마레드불에너지","월드컵의 상징 붉은악마를 표현한 새콤달콤한 체리콕 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        suggestions.add(new ProductDTO( R.drawable.suggest5,3600,"(HOT)레드오렌지뱅쇼티플레저","안토시아닌이 풍부하게 들어간 레드오렌지 뱅쇼베이스에 와인 티백을 활용한 티플레져"));


        iv_main_banner = v.findViewById(R.id.iv_main_banner);
        imgSlider = v.findViewById(R.id.imgSlider);
        recv_suggest = v.findViewById(R.id.recv_suggest);
        recv_notice = v.findViewById(R.id.recv_notice);
        iv_shopping = v.findViewById(R.id.iv_shopping);
        ln_coupon = v.findViewById(R.id.ln_coupon);
        ln_stamp = v.findViewById(R.id.ln_stamp);


        tv_slider_indicator = v.findViewById(R.id.tv_slider_indicator);

        Glide.with(v.getContext()).load(R.drawable.mainbanner).into(iv_main_banner);
        imgSlider.setClipToOutline(true); // 레이아웃에 낑겨줌
        imgSlider.setOffscreenPageLimit(1);
        imgSlider.setAdapter(new SliderAdapter(inflater,getContext(),images));

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(cnt == suggestions.size()) {
                    cnt = 0;
                }
                imgSlider.setCurrentItem(cnt++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 300, 2000);

        imgSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tv_slider_indicator.setText(position+1+ "/"+suggestions.size());
            }
        });
        recv_suggest.setAdapter(new SuggestAdapter(inflater,getContext(),suggestions));
        recv_suggest.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        recv_notice.setAdapter(new NoticeAdapter(inflater,getContext()));
        recv_notice.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        iv_shopping.setOnClickListener(this);
        ln_stamp.setOnClickListener(this);
        ln_coupon.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ln_coupon){
            Intent intent = new Intent(getContext(),CouponActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);

        } else if(v.getId() == R.id.ln_stamp){
            Intent intent = new Intent(getContext(),StampActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);

        } else if(v.getId() == R.id.iv_shopping){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.megamgccoffee.co.kr/"));
            startActivity(intent);
        }
    }

}