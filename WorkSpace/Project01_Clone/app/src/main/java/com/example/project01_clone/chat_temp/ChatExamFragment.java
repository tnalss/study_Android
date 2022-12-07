package com.example.project01_clone.chat_temp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;

import java.util.ArrayList;


public class ChatExamFragment extends Fragment {

    RecyclerView recv_exam_chat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_exam, container, false);
        recv_exam_chat = v.findViewById(R.id.recv_exam_chat);

        ArrayList<ChatExamDTO> list = new ArrayList<>();
        for(int i=0; i<10;i++) {
            list.add(new ChatExamDTO(R.drawable.profile_img1, "개똥이"+i, "안녕하세요", "오후 12:29"));
        }
        //ArrayList<?> list2 = new ArrayList<>();
        //와일드 키???????????

        recv_exam_chat.setAdapter(new ChatExamAdapter(inflater,list,getContext()));
        recv_exam_chat.setLayoutManager(CommonMethod.getManager(getContext()));

        return v;
    }
}