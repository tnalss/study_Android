package com.example.a13_clone_mgc.present;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.a13_clone_mgc.R;
import com.google.android.material.tabs.TabLayout;


public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        TabLayout tb_category;
        tb_category = v.findViewById(R.id.tb_category);

        tb_category.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if( tab.getPosition() == 0  ){

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