package com.example.a13_clone_mgc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.a13_clone_mgc.card.CardFragment;
import com.example.a13_clone_mgc.main.MainFragment;
import com.example.a13_clone_mgc.order.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;
    final String TAG="tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        changeFragment(new MainFragment());

        btm_nav = findViewById(R.id.btm_nav);

        btm_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.btm_item1){
                    changeFragment(new MainFragment());

                } else if (item.getItemId() == R.id.btm_item2){
                    changeFragment(new CardFragment());
                } else if (item.getItemId() == R.id.btm_item3){
                    changeFragment(new OrderFragment());
                }
                return true;
            }
        });
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

}