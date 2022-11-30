package com.example.and11_allview.listfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class Frag_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ListDTO> list;

    public Frag_Adapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
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
        convertView = inflater.inflate(R.layout.item_frag_listv,parent,false);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_time = convertView.findViewById(R.id.tv_time);
        
        tv_name.setText(list.get(position).getName());
        tv_time.setText(list.get(position).getTime()+" 초 전");
        
        return convertView;
    }
}
