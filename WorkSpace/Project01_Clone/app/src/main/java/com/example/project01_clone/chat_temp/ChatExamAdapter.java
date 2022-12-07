package com.example.project01_clone.chat_temp;

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

//3. 리사이클러뷰는 반드시 뷰홀더를 강제하기 때문에 1,2번 작업 후 Adapter를 상속받는다
//내가 만든게 <>안에 들어갔는지 확인!!!
//모양확인 -> onCreateViewHolder메소드 , getItemCount ==> 이제 중복된 모양으로 디자인확인가능
public class ChatExamAdapter extends RecyclerView.Adapter<ChatExamAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<ChatExamDTO> list;
    Context context;
//getter setter로 context가져올수도 있다
    public ChatExamAdapter(LayoutInflater inflater, ArrayList<ChatExamDTO> list, Context context) {
        this.inflater = inflater;
        this.list =list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_recv_examchat,parent,false));
    }


    // bind, binding => 어떤 화면에 보이는 요소와 화면에 보이지 않는 데이터가 연결이 되었나??
// 데이터 한칸을 저장해놓은 DTO화면에 보이는 요소
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_chat_name.setText(list.get(position).getChat_name());
        holder.tv_chat_msg.setText(list.get(position).getChat_msg());
        holder.tv_chat_date.setText(list.get(position).getChat_date());

        holder.ln_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //여기서도 가져올수있음 편법임
                Context con_temp = v.getContext();

                //Intent intent = new Intent(con_temp,ChatExamActivity.class);
                Intent intent = new Intent(context,ChatExamActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 1. 위젯들을 재활용하기위해서 묶어두기위한 위젯용 DTO -> ViewHolder
    // 2. androidx의 ViewHolder를 상속받는다
    public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imgv_chat_profile;
    TextView tv_chat_name,tv_chat_msg,tv_chat_date;
    LinearLayout ln_chat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv_chat_profile = itemView.findViewById(R.id.imgv_chat_profile);
            tv_chat_name = itemView.findViewById(R.id.tv_chat_name);
            tv_chat_msg=itemView.findViewById(R.id.tv_chat_msg);
            tv_chat_date = itemView.findViewById(R.id.tv_chatdate);
            ln_chat = itemView.findViewById(R.id.ln_chat);
        }
    }

    //버그잡기
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
