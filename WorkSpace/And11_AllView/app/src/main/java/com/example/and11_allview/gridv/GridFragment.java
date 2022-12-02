package com.example.and11_allview.gridv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.and11_allview.R;


public class GridFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_grid, container, false);

        GridAdapter adapter = new GridAdapter(inflater);

        GridView gridv= v.findViewById(R.id.gridv);
        gridv.setAdapter(adapter);

        return v;
    }
}