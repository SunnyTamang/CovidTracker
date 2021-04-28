package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chipNavigationBar = findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null){
            chipNavigationBar.setItemSelected(R.id.home,true);
            manager = getSupportFragmentManager();
            HomeFragment firstFrag = new HomeFragment();
            manager.beginTransaction().replace(R.id.fragment_container1,firstFrag).commit();

        }

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.support:
                        fragment = new SupportFragment();
                        break;
                    case R.id.favourite:
                        fragment = new ThirdFragment();
                        break;

                }
                if (fragment!=null){
                    manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container1,fragment).commit();

                }else {

                }
            }
        });
    }
}