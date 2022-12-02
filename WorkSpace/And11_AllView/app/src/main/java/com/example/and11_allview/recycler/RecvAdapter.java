package com.example.and11_allview.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;


//2 . 밑에서 만든 ViewHolder를 이용해서 "RecyclerViewAdapter"를 상속받는다!
// <>에 우리가 만든 ViewHolder를 넣어준다.
public class RecvAdapter extends RecyclerView.Adapter<RecvAdapter.CSMViewHolder> {

    LayoutInflater inflater;

    public RecvAdapter(LayoutInflater inflater) {
        this.inflater=inflater;
    }

    //3. onCreateViewHolder 메소드
    // 우리가 만들어 놓은 ViewHolder를 실제로 만들고 return 해주는 부분
    // viewholder는 몇개의 위젯이 들어있는지 os가 판단하는게 아니라 우리가 커스텀해서 사용
    // 어떤 아이템에는 이미지뷰가 3개, 어떤 아이템에는 텍뷰가 3개로 다를 수가 있음

    // getView랑 비슷한 메소드//viewgroup parent --> 붙는곳!!
    // 여기서도 역시나 layoutInflater가 필요하다!
    // 어댑터가 붙일수 있는 공간을 마련해주면 layoutInflater를 이용해 붙여줘야함!
    @NonNull
    @Override
    public CSMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //뷰가없으니 뷰를만들자.
        View v= inflater.inflate(R.layout.item_gridf_gridv,parent,false);
        CSMViewHolder viewHolder = new CSMViewHolder(v);
        return viewHolder;

        //한줄로는 return new CSMViewHolder(inflater.inflate(R.layout.item_gridf_gridv,parent,false));
    }

    //5. 데이터가 있다면 position holder에 담아져있는 (칸) 위젯과 연결부분 (Binding)
    @Override
    public void onBindViewHolder(@NonNull CSMViewHolder h, int i) {
        h.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.imgv1.getVisibility() == View.VISIBLE){
                    h.imgv1.setVisibility(View.GONE);
                    h.imgv2.setVisibility(View.VISIBLE);
                }else{
                    h.imgv1.setVisibility(View.VISIBLE);
                    h.imgv2.setVisibility(View.GONE);

                }
            }
        });
    }


    //4. item의 개수를 지정하는 getItemCount() 메소드
    @Override
    public int getItemCount() {
        return 30;
    }



    // 일반클래스가 아니라 viewholder타입
    // 1. androidx 에 있는 recyclerView홀더를 상속받음
    // ViewHolder타입을 상속받음 ""InnerClass"" ViewHolder를 만든다. ( 이름은 관례상 ViewHolder)

    public class CSMViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv1, imgv2;
        Button btn_change;
        public CSMViewHolder(@NonNull View v) {
            super(v);
            //위젯들을 찾아서 초기화하는 기능을 했음.
            imgv1 = v.findViewById(R.id.imgv1);
            imgv2 = v.findViewById(R.id.imgv2);
            btn_change = v.findViewById(R.id.btn_change);
        }
    }

    //6. 중요!! position이 꼬여서 데이터가 맘대로 통제가 안되는 경우******************
    //recyclerView 자체의 issue => getItemId와 getItemViewType 두개를 override해주어야함!!!!


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
