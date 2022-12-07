package com.example.project01_clone.chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<ChatDTO> list;

    public ChatAdapter(LayoutInflater inflater,Context context, ArrayList<ChatDTO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_chatlist,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_chatlist_name.setText( list.get(position).getName() );
        holder.tv_chatlist_msg.setText( list.get(position).getMsg() );
        holder.imgv_chatlist_profile.setImageResource( list.get(position).getImgRes() );

        final int idx = position;
        holder.ll_each.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ChatActivity.class);
                intent.putExtra("dto",list.get(idx));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_each;
        ImageView imgv_chatlist_profile;
        TextView tv_chatlist_name,tv_chatlist_msg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_each = itemView.findViewById(R.id.ll_each);
            imgv_chatlist_profile = itemView.findViewById(R.id.imgv_chatlist_profile);
            tv_chatlist_name = itemView.findViewById(R.id.tv_chatlist_name);
            tv_chatlist_msg = itemView.findViewById(R.id.tv_chatlist_msg);
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
