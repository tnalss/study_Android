package com.example.project01_clone.friendlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project01_clone.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

        ImageView imgv_detail_profile;
        TextView tv_detail_name,tv_detail_message;

        LinearLayout ll_detail_chat, ll_call, ll_detail_facetalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().hide();//액션바 숨기는 처리



        imgv_detail_profile = findViewById(R.id.imgv_detail_profile);
        tv_detail_name = findViewById(R.id.tv_detail_name);
        tv_detail_message = findViewById(R.id.tv_detail_message);

        Intent intent = getIntent();
        FriendDTO dto = (FriendDTO) intent.getSerializableExtra("dto");
        imgv_detail_profile.setImageResource(dto.getImgRes());
        tv_detail_name.setText(dto.getName());
        tv_detail_message.setText(dto.getMsg());

        ll_detail_chat=findViewById(R.id.ll_detail_chat);
        ll_call= findViewById(R.id.ll_call);
        ll_detail_facetalk = findViewById(R.id.ll_detail_facetalk);

        ll_detail_chat.setOnClickListener(this);
        ll_call.setOnClickListener(this);
        ll_detail_facetalk.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        //Intent 컴포넌트들간의 통신을 맞고 있는 객체 (액티비티)
        //1. 명시적 인텐트 ( 우리가 만든 클래스 내부에서 그 통제가 전부 가능한 상태)
        // ex) Intent intent = new Intent (현재위치context, 다음 띄울 액티비티.class)
        //2. 묵시적(암시적) 인텐트 ( 우리가 만든게 x , OS나 다른 기타 외부에서 제공하는 기능과 통신(호출))할때 사용하는 인탠트
        // 우리가 만든게 아니기 때문에 어떤 결과가 나올지 모름
        //ex) 인터넷연결, 전화연결, 카메라, 갤러리,맵등...
        Intent intent=null;
        if (v.getId()==R.id.ll_detail_chat){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        }else if (v.getId() == R.id.ll_call){
            intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01023004390"));

        }else if (v.getId()==R.id.ll_detail_facetalk){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,"hihhi");
            sendIntent.setType("text/plain");
            intent = Intent.createChooser(sendIntent,null);

        }
        startActivity(intent);
    }
}