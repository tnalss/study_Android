package com.example.and11_allview.recycler_melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

import java.util.ArrayList;

public class MelonAdapter extends RecyclerView.Adapter<MelonAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<MelonDTO> list;

    public MelonAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_melon,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.iv_img.setImageResource(list.get(i).getNo_img());
        h.tv_musicTitle.setText(list.get(i).getTitle());
        h.tv_rank.setText(list.get(i).getRank()+"");
        h.tv_musicSinger.setText(list.get(i).getSinger());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_musicTitle,tv_rank,tv_musicSinger;
        public ViewHolder(@NonNull View v) {
            super(v);
            iv_img = v.findViewById(R.id.iv_img);
            tv_musicTitle = v.findViewById(R.id.tv_musicTitle);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_musicSinger= v.findViewById(R.id.tv_musicSinger);

        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
