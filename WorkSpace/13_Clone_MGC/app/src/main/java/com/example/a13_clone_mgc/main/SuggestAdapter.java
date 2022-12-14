package com.example.a13_clone_mgc.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a13_clone_mgc.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class SuggestAdapter extends RecyclerView.Adapter<SuggestAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ProductDTO> list;

    public SuggestAdapter(LayoutInflater inflater, Context context, ArrayList<ProductDTO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_suggest,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_suggest_name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImageSrc()).dontAnimate().into(holder.cv_suggest_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView cv_suggest_img;
        TextView tv_suggest_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_suggest_img = itemView.findViewById(R.id.cv_suggest_img);
            tv_suggest_name = itemView.findViewById(R.id.tv_suggest_name);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
