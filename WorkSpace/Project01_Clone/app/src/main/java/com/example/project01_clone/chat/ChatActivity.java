package com.example.project01_clone.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project01_clone.R;
import com.example.project01_clone.friendlist.FriendDTO;

import java.io.File;

public class ChatActivity extends AppCompatActivity {
    TextView tv_chat_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getSupportActionBar().hide();
        tv_chat_name=findViewById(R.id.tv_chat_name);

        Intent intent = getIntent();
        try {
            FriendDTO dto = (FriendDTO) intent.getSerializableExtra("dto");
        tv_chat_name.setText(dto.getName());
        }catch(Exception e){
            ChatDTO dto = (ChatDTO) intent.getSerializableExtra("dto");
        tv_chat_name.setText(dto.getName());
        }




    }
}