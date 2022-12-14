package com.example.a13_clone_mgc.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;

public class ListSelectFragment extends Fragment {

    RecyclerView recv_list_select;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_select, container, false);

        recv_list_select = v.findViewById(R.id.recv_list_select);

        return v;
    }
}