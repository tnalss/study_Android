package com.example.teamptemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
    Button btn_insert, btn_return, btn_order_p1, btn_order_p2,btn_order_p3,btn_order_p4;
    EditText edt_money;
    TextView tv_p1_name,tv_p2_name,tv_p3_name,tv_p4_name;
    TextView tv_p1_qty,tv_p2_qty,tv_p3_qty,tv_p4_qty,tv_r_money;

    int money=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new ProductDTO("콜라",1000,3));
        list.add(new ProductDTO("사이다",900,5));
        list.add(new ProductDTO("환타",700,2));
        list.add(new ProductDTO("데미소다",600,1));

        tv_p1_name=findViewById(R.id.tv_p1_name);
        tv_p2_name=findViewById(R.id.tv_p2_name);
        tv_p3_name=findViewById(R.id.tv_p3_name);
        tv_p4_name=findViewById(R.id.tv_p4_name);

        tv_p1_qty=findViewById(R.id.tv_p1_qty);
        tv_p2_qty=findViewById(R.id.tv_p2_qty);
        tv_p3_qty=findViewById(R.id.tv_p3_qty);
        tv_p4_qty=findViewById(R.id.tv_p4_qty);

        btn_order_p1=findViewById(R.id.btn_order_p1);
        btn_order_p2=findViewById(R.id.btn_order_p2);
        btn_order_p3=findViewById(R.id.btn_order_p3);
        btn_order_p4=findViewById(R.id.btn_order_p4);

        btn_insert=findViewById(R.id.btn_insert);
        btn_return=findViewById(R.id.btn_return);

        edt_money=findViewById(R.id.edt_money);
        tv_r_money=findViewById(R.id.tv_r_money);

        tv_p1_name.setText(list.get(0).getName()+"     "+list.get(0).getPrice());
        tv_p2_name.setText(list.get(1).getName()+"     "+list.get(1).getPrice());
        tv_p3_name.setText(list.get(2).getName()+"     "+list.get(2).getPrice());
        tv_p4_name.setText(list.get(3).getName()+"     "+list.get(3).getPrice());

        tv_p1_qty.setText(list.get(0).getQty() +"개 남음");
        tv_p2_qty.setText(list.get(1).getQty() +"개 남음");
        tv_p3_qty.setText(list.get(2).getQty() +"개 남음");
        tv_p4_qty.setText(list.get(3).getQty() +"개 남음");

        btn_order_p1.setOnClickListener(this);
        btn_order_p2.setOnClickListener(this);
        btn_order_p3.setOnClickListener(this);
        btn_order_p4.setOnClickListener(this);
        btn_insert.setOnClickListener(this);
        btn_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == R.id.btn_return ){


        }else if(v.getId() == R.id.btn_insert){
            money= Integer.parseInt(edt_money.getText().toString());
            tv_r_money.setText("잔액 : "+money +"원");
        }else if(v.getId() == R.id.btn_order_p1){

        }
    }
}