package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {
    ListView listv_sub;
    ArrayList<ListDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        listv_sub = findViewById(R.id.listv_sub);

        LayoutInflater inflater = getLayoutInflater();
        //inflater를 List_Adapter가 사용할 수 있게 하려면
        // -> ListAdapter에 생성자를 만들어서 inflater를 사용할 수 있게 해줘야함.
        //ListAdapter 생성해보기

        // 한줄로는 List_Adapter adapter = new List_Adapter(getLayoutInflater());

        list = new ArrayList<>();

        for (int i = 1 ; i <= 30 ; i++ ){
            list.add(new ListDTO("영화"+i,i+"000명"));
        }

        //List_Adapter의 아이템 갯수 == list.size와 같게 처리해보기

        List_Adapter adapter = new List_Adapter(inflater,list);
        listv_sub.setAdapter(adapter);


    }
}