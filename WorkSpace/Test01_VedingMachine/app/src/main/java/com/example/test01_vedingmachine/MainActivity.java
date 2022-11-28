package com.example.test01_vedingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<DrinkDTO> list ;
    Button btn_input_money,btn_finish;
    TextView tv_money;
    EditText edt_input_money;
    int money;//금액을 누적시킬 변수
    ArrayList<DrinkDTO> result_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new DrinkDTO("콜라",1400,3, findViewById(R.id.tv_name1),findViewById(R.id.tv_cnt1),findViewById(R.id.btn_order_1) ));
        list.add(new DrinkDTO("사이다",800,6, findViewById(R.id.tv_name2),findViewById(R.id.tv_cnt2),findViewById(R.id.btn_order_2) ));
        list.add(new DrinkDTO("미린다",700,8, findViewById(R.id.tv_name3),findViewById(R.id.tv_cnt3),findViewById(R.id.btn_order_3) ));
        list.add(new DrinkDTO("맥콜",1200,9, findViewById(R.id.tv_name4),findViewById(R.id.tv_cnt4),findViewById(R.id.btn_order_4) ));

        edt_input_money = findViewById(R.id.edt_input_money);
        tv_money = findViewById(R.id.tv_money);
        btn_input_money = findViewById(R.id.btn_input_money);
        btn_finish = findViewById(R.id.btn_finish);

        tv_money.setText("0원");
        for(int i = 0 ; i< list.size() ; i++){
            list.get(i).getBtn_order().setOnClickListener(this);
            list.get(i).getBtn_order().setTag(i+""); // TAG 옷가게 옷에 붙어있는 택
        }


        btn_input_money.setOnClickListener(this);
        btn_finish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_input_money){
            //

            if(edt_input_money.getText().toString().length()<1){
                return;// 아무것도 입력안하고 버튼누른경우 날림
            }
            money += Integer.parseInt(edt_input_money.getText()+"");
            tv_money.setText(money + " 원");

        }else if(v.getId()==R.id.btn_finish){
            //마지막 처리
        } else {
            Log.d("로그", "onClick: 버튼클릭됨 " + v.getTag());
            int index = Integer.parseInt((v.getTag() + ""));
            if (list.get(index).getCnt() == 0) {
                Toast.makeText(this, "재고 부족", Toast.LENGTH_SHORT).show();
                return;
            } else if (money < list.get(index).getPrice()){
                Toast.makeText(this, "잔액 부족", Toast.LENGTH_SHORT).show();
                return;
        }
            money -= list.get(index).getPrice();
            tv_money.setText(money+"");
            list.get(index).setCnt(list.get(index).getCnt() - 1); //기존 수량 -1
        }
    }
}