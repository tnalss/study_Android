package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout ln_layout,ln_layout2;
    Button btn_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ln_layout = findViewById(R.id.ln_layout);
        ln_layout2 = findViewById(R.id.ln_layout2);

        LayoutInflater inflater = getLayoutInflater();

        View v1 = inflater.inflate(R.layout.layout_sub1,ln_layout,true);
        //xml에 있는 내용이 메모리에 올라감. 그런 뒤 메모리에 올라간 모든 내용을 다시 return해줌
        View v2 = inflater.inflate(R.layout.layout_sub2,ln_layout2,true);

        NoneContext noContext = new NoneContext(getLayoutInflater());

        TextView tv_sub1= v1.findViewById(R.id.tv_sub1);
        tv_sub1.setText("바뀐 글씨");
        Button btn_sub1 = v1.findViewById(R.id.btn_sub1);
        btn_sub1.setText("버튼 글씨바꾸기!!");
        // return해준 view타입을 활용해서 위젯을 찾는 작업을 해야한다!!

        Button btn_sub2 = v2.findViewById(R.id.btn_sub2);
        TextView tv_sub2= v2.findViewById(R.id.tv_sub2);
        //v2에 있는 버튼 클릭 -> v2의 텍스트가 바뀌는 처리를 해본다.
        btn_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_sub2.setText("버튼눌러서 글씨바꿈!");
                Toast.makeText(MainActivity.this, "토스트", Toast.LENGTH_SHORT).show();
                noContext.v1Setting(v1);
            }
        });

        btn_sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                noContext.method1();
                noContext.showToast( MainActivity.this );

            }
        });



        Toast.makeText(this, "토스트", Toast.LENGTH_SHORT).show();
        //context란?
        // 현재화면에 떠있는 객체에게 어떤 기능들을 사용할 수 있는 권한을 줌.
        // Context <= 1. Activity를 넘겨주면 된다.

        btn_new=findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mainActivity에서 intent를 이용해 subActivity를 열어보자.
                //mainactivity ----inent ---> subActivity
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("sVal","스트링 값을 넘겨보자!");
                intent.putExtra("iVal",100);

                MemberDTO dto = new MemberDTO("김개똥","01012345678","남");
                intent.putExtra("dto",dto);


                ArrayList<MemberDTO> list = new ArrayList<>();
                list.add(new MemberDTO("간첩","111","여"));
                list.add(new MemberDTO("소방관","119","남"));
                list.add(new MemberDTO("간호사","166161","여"));
                list.add(new MemberDTO("김소똥","01054665","남"));
                list.add(new MemberDTO("김말똥","12228812","남"));
                list.add(new MemberDTO("푸드파이터","8888888","남"));
                list.add(new MemberDTO("뭐머깆","112","남"));
                list.add(new MemberDTO("ㄷㄹㄷㄹㄷㄹ","15773082","남"));
                list.add(new MemberDTO("ㅇㄴㅁㄹㅇ","19819889","남"));
                list.add(new MemberDTO("ㅍㅍㅍ","118982","남"));

                intent.putExtra("list",list);
                startActivity(intent);// startActivity() AppComatActivity를 상속받은 액티비티만 사용가능
            }
        });

    }
}