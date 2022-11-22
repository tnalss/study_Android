package com.example.and06_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn, btn_login;
    TextView tv;
    RadioButton rdo_1, rdo_2;
    //여기서 연결하면 안되는 이유 : 아직 뷰랑 연결이 안되었음. 뷰랑 연결하는 부분은 setContentView 메소드 부분
    // 수명주기 (Life Cycle) : onCreate
    // 렌더링 (web) : DOM(Document Object Model).
    RadioGroup rdo_grp;
    EditText edt_id, edt_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv_txt);
        //모든 위젯(Button포함)이 null이 아닌 상태일때 => Event를 줄 수 있다.
        rdo_1 = findViewById(R.id.rdo_male);
        rdo_2 = findViewById(R.id.rdo_female);

        rdo_grp = findViewById(R.id.rdo_grp);


        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        // edt_id에 현재 입력 된 값을 가져오는 메소드는 edt_id.getText()
        // btn_login이 클릭이 되면 edt_id의값이 admin 이고 edt_pw의 값이 1234 일때 로그인이 되게 처리해보기.
        // 로그인==> 로그에 로그인이 되었습니다.
        // 그외에는 아이디 또는 비밀번호를 확인해주세요.

        //※ 사용자 : edt_pw 에 어떤값이든 입력을 할 예정
        // 메소드를 이용해서 해당하는 edt_pw 위젯에 있는값이 숫자이면 로그인을 진행하고
        // 그게아니라면 숫자만 입력해주세요 라는 메세지가 콘솔에 출력되게 처리

        //edt_pw에 입력 된 값이 숫자인지를 판단해서 해당하는 숫자를 리턴하는 메소드!
        rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String what = null;
                switch (checkedId) {
                    case 1:
                        what = "아주나쁨";
                        break;
                    case 2:
                        what = "나쁨";
                        break;
                    case 3:
                        what = "보통";
                        break;
                    case 4:
                        what = "좋음";
                        break;
                    case 5:
                        what = "매우좋음";
                        break;
                    default:
                        what = "안누른듯?";
                        break;
                }
                Log.d("로그", "라디오 버튼 : " + what);
                //디버깅모드를 활용해서 문제를 해결해보기
                //라디오버튼이 어떤게 클릭되었는지 알수 있으려면 어떻게 해야할까?
                RadioButton temp_rdo = (RadioButton) group.getChildAt(checkedId - 1);
                Log.d("로그", "onCheckedChanged: " + temp_rdo.getText());
            }
        });


        btn.setOnClickListener(this);
        tv.setOnClickListener(this);


        //is <= boolean
        //isChecked <= 해당하는 라디오 버튼이 체크된 상태를 우리한테 넘겨줌.
        //체크가 되었다면 rdo_2의 체크상태를 해제
        rdo_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rdo_2.setChecked(!isChecked);
                }
            }
        });

        rdo_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rdo_1.setChecked(!isChecked);
                }
            }
        });


        btn_login.setOnClickListener(this);

    }

    boolean isNumber() {
        try {
            Integer.parseInt(edt_pw.getText().toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    int numberCheck(){
        try {
            return Integer.parseInt(edt_pw.getText().toString());
        } catch (Exception e) {
        }
            return -1;
    }
    String rtn_str(){
        try{
            Integer.parseInt(edt_id.getText().toString());
            Log.d("로그", "숫자로바꿀수없는 문자열을 입력해주세요");
            return "error";
        }catch (Exception e){
            return edt_id.getText()+"";
        }

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            tv.setText("버튼 클릭됨");
        } else if (v.getId() == R.id.tv_txt) {
            btn.setText("텍뷰 클릭됨");
        } else if (v.getId() == R.id.btn_login) {
            rtn_str();
            numberCheck();
            if (isNumber()) {
                if (String.valueOf(edt_id.getText()).equals("admin") && String.valueOf(edt_pw.getText()).equals("1234")) {
                    Log.d("로그", "로그인이 되었습니다.");
                } else {
                    Log.d("로그", "아이디 패스워드를 확인하세요.");
                }
            } else {
                Log.d("로그", "비밀번호는 숫자만 입력가능합니다.");
            }

        }
    }
}