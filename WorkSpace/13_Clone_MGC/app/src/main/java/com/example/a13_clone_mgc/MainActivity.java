package com.example.a13_clone_mgc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.a13_clone_mgc.card.CardFragment;
import com.example.a13_clone_mgc.main.MainFragment;
import com.example.a13_clone_mgc.more.MoreFragment;
import com.example.a13_clone_mgc.order.OrderFragment;
import com.example.a13_clone_mgc.present.PresentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity{
    public BottomNavigationView btm_nav;
    final String TAG="tag";
    double waitTime=0;
    /*해시키 구하는 메소드 for 카카오맵*/
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
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();




        changeFragment(new MainFragment());




        btm_nav = findViewById(R.id.btm_nav);

        //dialog를 위한 세팅 https://wuny-dev.tistory.com/m/19
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount=0.8f;
        getWindow().setAttributes(layoutParams);


        btm_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.btm_item1){
                    changeFragment(new MainFragment());
                } else if (item.getItemId() == R.id.btm_item2){
                    changeFragment(new CardFragment());
                } else if (item.getItemId() == R.id.btm_item3){
                    changeFragment(new OrderFragment());
                } else if (item.getItemId() == R.id.btm_item4){
                    changeFragment(new PresentFragment());
                } else if (item.getItemId() == R.id.btm_item5){
                    changeFragment(new MoreFragment());
                }

                return true;
            }
        });
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis();

        } else {
            super.onBackPressed(); // 액티비티 종료
        }
    }


}