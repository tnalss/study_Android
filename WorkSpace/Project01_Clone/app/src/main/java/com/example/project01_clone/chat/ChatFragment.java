package com.example.project01_clone.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;


public class ChatFragment extends Fragment {
        RecyclerView recv_chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        recv_chat = v.findViewById(R.id.recv_chat);

        recv_chat.setAdapter(new ChatAdapter(inflater,getContext()));
        recv_chat.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        return v;
    }
}