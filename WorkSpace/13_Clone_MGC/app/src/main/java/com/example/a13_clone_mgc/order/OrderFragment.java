package com.example.a13_clone_mgc.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;
import com.google.android.material.tabs.TabLayout;

import net.daum.mf.map.api.MapView;

public class OrderFragment extends Fragment {

    TabLayout tb_order;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);

        tb_order = v.findViewById(R.id.tb_order);
        getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new ListSelectFragment()).commit();


        tb_order.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0 ){
                    getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new ListSelectFragment()).commit();
                } else if ( tab.getPosition() == 1){
                    getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new MapSelectFragment()).commit();

                } else if ( tab.getPosition() ==2 ){
                    getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new FavoriteFragment() ).commit();

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