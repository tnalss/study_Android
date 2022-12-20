package com.example.a13_clone_mgc.present;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;
import com.example.a13_clone_mgc.main.ProductDTO;
import com.example.a13_clone_mgc.main.SuggestAdapter;

import java.util.ArrayList;


public class PresentMainFragment extends Fragment {
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recv_food,recv_best,recv_card;
        ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
        View v = inflater.inflate(R.layout.fragment_present_main, container, false);

        recv_food = v.findViewById(R.id.recv_food);
        recv_best = v.findViewById(R.id.recv_best);
        recv_card = v.findViewById(R.id.recv_card);

        list.add(new ProductDTO( R.drawable.suggest1,3500,"스모어블랙쿠키프라페","진한 초코스무디에 바삭한 쿠키를 넣어 퐁신퐁신한 마시멜로우 잼과 함께 달콤하게 즐기는 스무디"));
        list.add(new ProductDTO( R.drawable.suggest2,4000,"따끈따끈간식꾸러미","겨울에 생각나는 팥붕어빵,초코조개빵,앙버터호두과자로 구성된 따끈한 간식꾸러미"));
        list.add(new ProductDTO( R.drawable.suggest3,3800,"태극전사레드불에너지","우리나라 국기의 태극 문양을 표현한 트로피컬 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        list.add(new ProductDTO( R.drawable.suggest4,3700,"붉은악마레드불에너지","월드컵의 상징 붉은악마를 표현한 새콤달콤한 체리콕 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        list.add(new ProductDTO( R.drawable.suggest5,3600,"(HOT)레드오렌지뱅쇼티플레저","안토시아닌이 풍부하게 들어간 레드오렌지 뱅쇼베이스에 와인 티백을 활용한 티플레져"));

        recv_food.setAdapter(new SuggestAdapter(inflater,getContext(),list));
        recv_best.setAdapter(new SuggestAdapter(inflater,getContext(),list));
        recv_card.setAdapter(new SuggestAdapter(inflater,getContext(),list));

        recv_food.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recv_best.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recv_card.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        return v;
    }
}