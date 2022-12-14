package com.example.a13_clone_mgc.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;


public class FavoriteFragment extends Fragment {

    RecyclerView recv_favorite;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_facvorite, container, false);

        recv_favorite = v.findViewById(R.id.recv_favorite);

        recv_favorite.setAdapter(new FacvoriteAdapter(inflater,getContext()));
        recv_favorite.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        return v;
    }
}