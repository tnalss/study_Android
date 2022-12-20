package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText edt_id, edt_pw;
    ImageView imgv_kakao_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        imgv_kakao_login = findViewById(R.id.imgv_kakao_login);

        ApiClient.setBASEURL("http://192.168.0.15/middle/");
        KakaoSdk.init(this, "acb6f17c56349e3617a1057ea4b976c2");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CommonMethod().setParams("email", edt_id.getText().toString())
                        .setParams("pw", edt_pw.getText().toString())
                        .sendPost("login", new CommonMethod.CallbackResult() {
                            @Override
                            public void result(boolean isResult, String data) {

                                Log.d("로그", "result: " + data);
                            }
                        });
            }

        });

        imgv_kakao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kakaoLogin();
            }
        });


    }

    //      1JD158uA3VQVnyOfk+aOcG8TNwk=
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("로그", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("로그", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

//크롬 오류시 사용중지후 다시해보기!
    private void kakaoLogin(){
        Function2<OAuthToken, Throwable, Unit> callback =  new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null) {
                    Log.d("로그", "invoke: " + oAuthToken);
                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                            Log.d("로그", "invoke: "+user.getId());
                            Log.d("로그", "invoke: "+user.getKakaoAccount().getEmail());
                            Log.d("로그", "invoke: "+user.getKakaoAccount().getProfile().getNickname());
                            Log.d("로그", "invoke: "+user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                            socialLogin(user.getKakaoAccount().getEmail());
                            return null;
                        }
                    });
                }
                return null;
            }
        };

        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)) {
            UserApiClient.getInstance().loginWithKakaoTalk(this,callback);

        } else {
            UserApiClient.getInstance().loginWithKakaoAccount(this,callback);
        }


        // 카카오계정으로 로그인
/*        UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            }
            else if (token != null) {
                Log.i(TAG, "로그인 성공 ${token.accessToken}")
            }
        }*/
    }



    //
    public void socialLogin(String email){
        //소셜 로그인을 통해서 가져온 정보를 Spring으로 전송하기 (oracle테이블에 해당하는 메일로 가입한 정보)
        //1. 가입한 정보가 있다면 로그인 성공 처리
        //2. 가입한 정보가 없다면 회원가입 처리

        new CommonMethod().setParams("email",email).sendPost("social.me", new CommonMethod.CallbackResult() {
            @Override
            public void result(boolean isResult, String data) {
                Log.d("로그", "result: 전송성공");
            }
        });
    }
}




//               if( edt_id.getText().toString().equals("admin") && edt_pw.getText().toString().equals("admin_pw")){
//                   Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                   LoginActivity.this.startActivity(intent);
//               } else {
//                   Toast.makeText(LoginActivity.this, "아이디/패스워드 확인", Toast.LENGTH_SHORT).show();
//               }
