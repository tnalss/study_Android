package com.example.test01_listview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public SubAdapter(LayoutInflater inflater,ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list =list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.list_sub,parent,false);
        ImageView iv_thumnail = convertView.findViewById(R.id.iv_thumnail);
        TextView tv_title = convertView.findViewById(R.id.tv_title);
        TextView tv_content = convertView.findViewById(R.id.tv_content);

        //https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=sohyoun74&logNo=90179026875
        iv_thumnail.setImageResource( convertView.getResources().getIdentifier(list.get(position).getIv_thumnail(),"drawable",convertView.getContext().getPackageName()));
        tv_title.setText(list.get(position).getTitle());
        tv_content.setText(list.get(position).getContent());

       return convertView;
    }
}
