package com.example.a13_clone_mgc.present;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;
import com.google.android.material.tabs.TabLayout;

public class PresentBoxFragment extends Fragment {

    TabLayout tb_present_box;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_present_box, container, false);
        tb_present_box = v.findViewById(R.id.tb_present_box);

        getChildFragmentManager().beginTransaction().replace(R.id.fl_receive,new ReceivePresentFragment()).commit();


        tb_present_box.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if( tab.getPosition() == 0 ){
                    getChildFragmentManager().beginTransaction().replace(R.id.fl_receive,new ReceivePresentFragment()).commit();
                } else if (tab.getPosition() ==1 ){
                    getChildFragmentManager().beginTransaction().replace(R.id.fl_receive,new SendPresentFragment()).commit();

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