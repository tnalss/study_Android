package com.example.a13_clone_mgc.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;

import net.daum.mf.map.api.MapView;

public class MapSelectFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map_select, container, false);

        MapView mapView = new MapView(getContext());
        ViewGroup mapViewContainer = (ViewGroup) v.findViewById(R.id.mapView);
        mapViewContainer.addView(mapView);

        return v;
    }
}