package com.example.test01_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    ListView lv_list;
    ArrayList<ListDTO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        lv_list = findViewById(R.id.lv_list);

        list = new ArrayList<>();
        String resNum="";
        for (int i = 1 ; i <= 10 ; i++) {
            resNum="img"+i;
            list.add(new ListDTO(resNum, "제목" + i, "내용" + i));
        }

        SubAdapter adapter = new SubAdapter(getLayoutInflater(),list);

        lv_list.setAdapter(adapter);

    }
}