package com.example.a13_clone_mgc.present;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.a13_clone_mgc.R;
import com.google.android.material.tabs.TabLayout;

public class PresentFragment extends Fragment {

    TabLayout tb_present;
    FrameLayout fm_tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_present, container, false);
        tb_present = v.findViewById(R.id.tb_present);
        fm_tab = v.findViewById(R.id.fm_tab);

        getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new PresentMainFragment()).commit();

        tb_present.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if ( tab.getPosition() == 0 ){
                    getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new PresentMainFragment()).commit();
                } else if (tab.getPosition() == 1) {
                    getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new CategoryFragment()).commit();
                } else if ( tab.getPosition() == 2 ){
                    getChildFragmentManager().beginTransaction().replace(R.id.fm_tab,new PresentBoxFragment()).commit();
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