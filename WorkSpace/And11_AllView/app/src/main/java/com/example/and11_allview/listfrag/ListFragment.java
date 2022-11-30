package com.example.and11_allview.listfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView listv_frag;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        listv_frag= v.findViewById(R.id.listv_frag);

        ArrayList<ListDTO> list = new ArrayList<>();
        for(int i = 0 ; i <=20 ;i++){
            list.add(new ListDTO("카페"+i, i+2));
        }

        Frag_Adapter adapter = new Frag_Adapter(inflater, list);
        //inflater가 있기때문에 get으로 안가져와서 써도된다!!!!!
        listv_frag.setAdapter(adapter);
        return v;
    }
}