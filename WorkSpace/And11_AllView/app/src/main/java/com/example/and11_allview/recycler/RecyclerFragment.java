package com.example.and11_allview.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;


public class RecyclerFragment extends Fragment {

    RecyclerView recv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_recycler, container, false);
        recv = v.findViewById(R.id.recv);
        RecvAdapter adapter = new RecvAdapter(inflater);
        recv.setAdapter(adapter);
        //리사이클러뷰는 가로뷰와 세로뷰(orientation) 을제공함. ==>  layoutManager가 필요하다.

        //리니어 레이아웃매니저로 만들어야 편하다!!
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recv.setLayoutManager(manager);

        return v;
    }
}