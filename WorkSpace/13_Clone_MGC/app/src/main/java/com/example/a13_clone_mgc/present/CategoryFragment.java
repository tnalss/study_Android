package com.example.a13_clone_mgc.present;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.a13_clone_mgc.R;
import com.google.android.material.tabs.TabLayout;


public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        TabLayout tb_category;
        RecyclerView recv_present_tab;
        tb_category = v.findViewById(R.id.tb_category);
        recv_present_tab = v.findViewById(R.id.recv_present_tab);


        recv_present_tab.setAdapter(new VerticalAdapter(inflater,getContext()));
        recv_present_tab.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        tb_category.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if( tab.getPosition() == 0  ){
                        recv_present_tab.setAdapter(new VerticalAdapter(inflater,getContext()));
                        recv_present_tab.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

                } else if( tab.getPosition() == 1 ) {

                } else if( tab.getPosition() == 2 ) {

                } else if( tab.getPosition() == 3 ) {

                } else if( tab.getPosition() == 4 ) {

                } else if( tab.getPosition() == 5 ) {

                } else if( tab.getPosition() == 6 ) {

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }
}