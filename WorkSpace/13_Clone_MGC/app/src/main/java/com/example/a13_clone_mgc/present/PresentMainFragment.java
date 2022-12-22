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
        ArrayList<ProductDTO> food = new ArrayList<ProductDTO>();
        ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
        ArrayList<ProductDTO> card = new ArrayList<>();
        View v = inflater.inflate(R.layout.fragment_present_main, container, false);

        recv_food = v.findViewById(R.id.recv_food);
        recv_best = v.findViewById(R.id.recv_best);
        recv_card = v.findViewById(R.id.recv_card);

        food.add(new ProductDTO( R.drawable.product7,5400,"마르게리타피자","이탈리아산 듀럼밀을 사용한 쫄깃한 도우에 토마토소스, 모짜렐라 치즈 바질을 더해 든든하게 만든 풍미가득 마르게리타 피자"));
        food.add(new ProductDTO( R.drawable.product8,1900,"경산대추과즐","경산 대추와 우리 밀을 넣은 달콤 쫀득한 피에 국내산 조청과 쌀튀밥을 입혀 바삭하게 구운 한과" ));
        food.add(new ProductDTO( R.drawable.product9,5100,"허니버터피자","이탈리아산 듀럼밀을 사용한 쫄깃한 도우에 버터, 모짜렐라 치즈, 꿀을 더해 든든하게 만든 단짠단짠 허니버터 피자"));
        food.add(new ProductDTO( R.drawable.product10,2000, "에스프레소 도피오", "메가MGC커피의 원두 향미를 온전히 즐길 수 있는 투샷 에스프레소"));
        food.add(new ProductDTO( R.drawable.product11,2400,"에스프레소 피에노","에스프레소에 크림과 코코아 파우더를 올려 부드럽게 즐길 수 있는 음료"));
        food.add(new ProductDTO( R.drawable.product12,1500,"에스프레소","메가MGC커피 블렌딩 원두의 향미를 온전히 즐길 수 있는 메뉴"));
        food.add(new ProductDTO( R.drawable.product13,3200,"젤라또 아포가토", "바닐라 젤라또에 진한 에스프레소를 부어 만든 이탈리아 디저트"));

        list.add(new ProductDTO( R.drawable.product1,3500,"스모어블랙쿠키프라페","진한 초코스무디에 바삭한 쿠키를 넣어 퐁신퐁신한 마시멜로우 잼과 함께 달콤하게 즐기는 스무디"));
        list.add(new ProductDTO( R.drawable.product2,4000,"따끈따끈간식꾸러미","겨울에 생각나는 팥붕어빵,초코조개빵,앙버터호두과자로 구성된 따끈한 간식꾸러미"));
        list.add(new ProductDTO( R.drawable.product3,3800,"태극전사레드불에너지","우리나라 국기의 태극 문양을 표현한 트로피컬 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        list.add(new ProductDTO( R.drawable.product4,3700,"붉은악마레드불에너지","월드컵의 상징 붉은악마를 표현한 새콤달콤한 체리콕 맛의 에너지 드링크 (With Red Bull Sugarfree)"));
        list.add(new ProductDTO( R.drawable.product5,3600,"(HOT)레드오렌지뱅쇼티플레저","안토시아닌이 풍부하게 들어간 레드오렌지 뱅쇼베이스에 와인 티백을 활용한 티플레져"));

        card.add(new ProductDTO(R.drawable.card1,10000,"1만원 상품권","메가커피 1만원 상품권입니다."));
        card.add(new ProductDTO(R.drawable.card2,20000,"2만원 상품권","메가커피 2만원 상품권입니다."));
        card.add(new ProductDTO(R.drawable.card3,30000,"3만원 상품권","메가커피 3만원 상품권입니다."));
        card.add(new ProductDTO(R.drawable.card3,50000,"5만원 상품권","메가커피 5만원 상품권입니다."));

        recv_food.setAdapter(new PresentAdapter(inflater,this,food));
        recv_best.setAdapter(new PresentAdapter(inflater,this,list));
        recv_card.setAdapter(new PresentAdapter(inflater,this,card));

        recv_food.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recv_best.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recv_card.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        return v;
    }
}