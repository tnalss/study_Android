package com.example.and11_allview.gridv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.and11_allview.R;

public class GridAdapter extends BaseAdapter {
    LayoutInflater inflater;

    public GridAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    int count = 0;
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder viewHolder=null;

        if(v==null){
            v = inflater.inflate(R.layout.item_gridf_gridv,parent,false);
            viewHolder=new ViewHolder(v);
            v.setTag(viewHolder);
            //태그는 모든형식으로 달 수 있다.
            count++;
        }
       else {
            if (v.getTag() != null) {
                viewHolder = (ViewHolder) v.getTag();
            }
            Log.d("로그", "getView: " + count);
        }

       final ViewHolder tempViewHolder = viewHolder;
       //안에서 사용하려면 final이 있어야함.
       viewHolder.btn_change.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //index==0 -> (imageview1, imageview2, button)
               if(tempViewHolder.imgv1.getVisibility() == View.VISIBLE){
                   tempViewHolder.imgv1.setVisibility(View.GONE);
                   tempViewHolder.imgv2.setVisibility(View.VISIBLE);
               }else {
                   tempViewHolder.imgv1.setVisibility(View.VISIBLE);
                   tempViewHolder.imgv2.setVisibility(View.GONE);
               }
           }
       });

            return v;
    }

    // recylcler (재활용) : view (아이템붙인거) 한번 붙여놓고 나서 계쏙 새로 붙이면 너무 비효율적이고 느려진다!!
    // 한번 붙여놓은 아이템을 메모리에 저장해놨다 다시 사용하는 구조로 만들자 !! => RecylclerView의 특성
    // 위젯을 묶어놓은 DTO ==> ""ViewHolder""라고 부르기로함

    //recyclerview는 viewholder라는 클래스를 강제한다(무조건 만들어야한다!!!!!)
    public class ViewHolder{
        //필드 : 위젯들을 전부 다 써줌
        ImageView imgv1, imgv2;
        Button btn_change;

        public ViewHolder(View v){
            imgv1 = v.findViewById(R.id.imgv1);
            imgv2 = v.findViewById(R.id.imgv2);
            btn_change = v.findViewById(R.id.btn_change);

        }

    }
}
