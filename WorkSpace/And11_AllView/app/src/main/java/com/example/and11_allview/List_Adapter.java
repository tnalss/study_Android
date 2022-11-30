package com.example.and11_allview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//1. 일반클래스=> 어댑터 타입의 클래스 (extends로 상속)
public class List_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ListDTO> list;

    public List_Adapter(LayoutInflater inflater, ArrayList<ListDTO> list){
        this.inflater = inflater;
        this.list = list;
    }

    //2. getCount는 리스트뷰에 들어가는 내용의 개수를 지정한다.
    // ex) 10건의 목록을 보여주고 싶음 -> return 0;
    // ArrayList<Data> list => return list.size(); 이런식으로 가변적으로 활용가능
    @Override
    public int getCount() {
        return list.size();
    }

    //3. getItem은 ArrayList<Data> list가 있을때 index로 해당하는 칸의 정보를 빼올 때 사용
    @Override
    public Object getItem(int position) {

        return position;
    }

    //4. getItemId 칸에 별도의 아이디를 주고 싶다면 사용하는데 position값은 절대 중복되지 않기때문에
    // 그냥 position으로 사용한다.
    @Override
    public long getItemId(int position) {
        return position;
    }
//5. getView : 리스트뷰는 getCount에서 지정된 칸 만큼 getView를 실행하면서 한칸마다 ViewGroup을 제공한다 (Layout)
 //ViewGroup에 들어가는 내용을 붙이는 건 개발자가 직접함.
 //res에가서 아이템을만들자
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //layout을 붙이는 처리를 해야함.
        //list_adapter라는 클래스에서 layoutinflater 사용하게 만들어보기
        //생성자를 만들어 inflater를 받아오자!
        
        convertView = inflater.inflate(R.layout.item_sub_listv,parent,false);
        //이제 subactivity에서 연결해줘야함
        TextView tv_title = convertView.findViewById(R.id.tv_title);
        TextView tv_cnt = convertView.findViewById(R.id.tv_cnt);
        tv_title.setText(list.get(position).getTitle());
        tv_cnt.setText(list.get(position).getCnt());

        return convertView;
    }
}
