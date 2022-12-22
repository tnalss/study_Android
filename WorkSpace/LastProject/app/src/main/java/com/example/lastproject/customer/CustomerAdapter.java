package com.example.lastproject.customer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.lastproject.R;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<CustomerVO> list;
    CustomerActivity activity;
    final String TAG = "로그";


    public CustomerAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, CustomerActivity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity=activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_customer,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_id.setText("번호 : "+ list.get(position).getId() +"");
        holder.tv_name.setText( "이름 : " + list.get(position).getName());

        holder.btn_delete.setOnClickListener(v -> {
            checkDelete(list.get(position).getId());
        });

        holder.btn_detail.setOnClickListener(v -> {
            //CustomDialog
            Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.dialog_detail_cus);

            //디바이스 화면크기를 가져와서 다이알로그를 키워주는 방법
            DisplayMetrics metrics =activity.getResources().getDisplayMetrics();
            int device_width = metrics.widthPixels ;
            //0.5곱하면 터짐 int형이라
            int device_height = metrics.heightPixels * 50 / 100;

            dialog.getWindow().setLayout(device_width,device_height);

            TextView tv_id=dialog.findViewById(R.id.tv_id);
            TextView tv_name=dialog.findViewById(R.id.tv_name);
            TextView tv_email=dialog.findViewById(R.id.tv_email);
            TextView tv_phone=dialog.findViewById(R.id.tv_phone);
            TextView tv_gender=dialog.findViewById(R.id.tv_gender);

            tv_id.setText("아이디 :" + list.get(position).getId()+"");
            tv_name.setText("이름 : "+ list.get(position).getName()+"");
            tv_email.setText("이메일 : "+list.get(position).getEmail()+"");
            tv_phone.setText("전화 "+list.get(position).getPhone()+"");
            tv_gender.setText("성별 : "+ list.get(position).getGender()+"");

            dialog.show();//dialog show와 dismiss가 사용됨


        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_id;
        Button btn_detail, btn_edit,btn_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            btn_detail = itemView.findViewById(R.id.btn_detail);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);


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

    //네를 누르면 바로 삭제 처리 아니오를 누르면 아무처리도 하지 않음.
    public void checkDelete(int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("고객정보삭제").setMessage("정말로 삭제하시겠습니까?").setIcon(R.drawable.ic_launcher_background);
        builder.setPositiveButton("네",(dialog, which) -> {
            //네 누르면 실행되는 곳
            new CommonMethod().setParams("id",id).sendPost("delete.cu", (isResult, data) -> {
                Log.d(TAG, "onBindViewHolder: " +data);
                activity.selectList();
            });
        });

        builder.setNegativeButton("아니오",(dialog, which) -> {

        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
