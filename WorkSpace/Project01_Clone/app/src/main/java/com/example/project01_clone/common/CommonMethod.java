package com.example.project01_clone.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {
    //매번 화면에서 LayoutManager를 직접 만드는 행위가 불편,
    // 재사용이 가능한 메소드 하나를 이용해서 코드를 줄여 보고자 한다

    // 레이아웃 매니저를 리턴하는 메소드를 CommonMethod를 정의해보고
    // ChatExamFragment에서 호출해서 사용해보기


    public static LinearLayoutManager getManager(Context context, int orientation, boolean b) {
        return new LinearLayoutManager(context,orientation,false);
    }
    public static LinearLayoutManager getManager(Context context, int orientation) {
        return new LinearLayoutManager(context,orientation,false);
    }
    public static LinearLayoutManager getManager(Context context) {
        return new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
    }


}
