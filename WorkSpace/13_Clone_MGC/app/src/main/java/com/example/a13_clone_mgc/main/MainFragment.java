package com.example.a13_clone_mgc.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a13_clone_mgc.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView iv_main_banner;
        ViewPager2 imgSlider;
        RecyclerView recv_suggest;

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.carousel1);
        images.add(R.drawable.carousel2);
        images.add(R.drawable.carousel3);
        images.add(R.drawable.carousel4);
        images.add(R.drawable.carousel5);
        ArrayList<BeverageDTO> suggestions = new ArrayList<>();
        suggestions.add(new BeverageDTO( R.drawable.suggest1,"스모어블랙쿠키프라페","진한 초코스무디에 바삭한 쿠키를 넣어 퐁신퐁신한 마시멜로우 잼과 함께 달콤하게 즐기는 스무디"));
        suggestions.add(new BeverageDTO( R.drawable.suggest2,"따끈따끈간식꾸러미","겨울에 생각나는 팥붕어빵,초코조개빵,앙버터호두과자로 구성된 따끈한 간식꾸러미"));
        suggestions.add(new BeverageDTO( R.drawable.suggest3,"태극전사레드불에너지","우리나라 국기의 태극 문양을 표현한 트로피컬 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        suggestions.add(new BeverageDTO( R.drawable.suggest4,"붉은악마레드불에너지","월드컵의 상징 붉은악마를 표현한 새콤달콤한 체리콕 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        suggestions.add(new BeverageDTO( R.drawable.suggest5,"(HOT)레드오렌지뱅쇼티플레저","안토시아닌이 풍부하게 들어간 레드오렌지 뱅쇼베이스에 와인 티백을 활용한 티플레져"));


        iv_main_banner = v.findViewById(R.id.iv_main_banner);
        imgSlider = v.findViewById(R.id.imgSlider);
        recv_suggest = v.findViewById(R.id.recv_suggest);
        Glide.with(v.getContext()).load(R.drawable.mainbanner).into(iv_main_banner);
        imgSlider.setClipToOutline(true); // 레이아웃에 낑겨줌
        imgSlider.setOffscreenPageLimit(1);
        imgSlider.setAdapter(new SliderAdapter(inflater,getContext(),images));

        recv_suggest.setAdapter(new SuggestAdapter(inflater,getContext(),suggestions));
        recv_suggest.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        return v;
    }
}