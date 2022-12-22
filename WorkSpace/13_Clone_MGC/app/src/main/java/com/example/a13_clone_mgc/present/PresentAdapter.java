package com.example.a13_clone_mgc.present;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a13_clone_mgc.MainActivity;
import com.example.a13_clone_mgc.R;
import com.example.a13_clone_mgc.main.ProductDTO;
import com.example.a13_clone_mgc.main.SendNowActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PresentAdapter extends RecyclerView.Adapter<PresentAdapter.ViewHolder>{
    LayoutInflater inflater;
    PresentMainFragment fragment;
    ArrayList<ProductDTO> list;

    public PresentAdapter(LayoutInflater inflater, PresentMainFragment fragment, ArrayList<ProductDTO> list) {
        this.inflater = inflater;
        this.fragment = fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_suggest,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_suggest_name.setText(list.get(position).getName());
        Glide.with(fragment.getContext()).load(list.get(position).getImageSrc()).dontAnimate().into(holder.cv_suggest_img);
        final int i = position;
        holder.rl_each.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) fragment.getActivity();
            Intent intent = new Intent(fragment.getContext(), SendNowActivity.class);
            intent.putExtra("dto",list.get(i));
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView cv_suggest_img;
        TextView tv_suggest_name;
        RelativeLayout rl_each;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_suggest_img = itemView.findViewById(R.id.cv_suggest_img);
            tv_suggest_name = itemView.findViewById(R.id.tv_suggest_name);
            rl_each = itemView.findViewById(R.id.rl_each);
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
