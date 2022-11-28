package com.example.test01_vedingmachine;

import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class DrinkDTO implements Serializable {
    private String name;
    int price, cnt;
//dto의 내용 1건 ==> 텍스트뷰 x2 , 버튼 x1
    private TextView tv_name,tv_cnt;
    private Button btn_order;

    public DrinkDTO(String name, int price, int cnt, TextView tv_name, TextView tv_cnt, Button btn_order) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
        this.tv_name = tv_name;
        this.tv_cnt = tv_cnt;
        this.btn_order = btn_order;

        this.tv_name.setText(name+"  "+price + "  원");
        this.tv_cnt.setText(cnt + " 개 남음");
    }

    public TextView getTv_name() {
        return tv_name;
    }

    public TextView getTv_cnt() {
        return tv_cnt;
    }

    public Button getBtn_order() {
        return btn_order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
        this.tv_cnt.setText(cnt+" 개 남음");
    }
}
