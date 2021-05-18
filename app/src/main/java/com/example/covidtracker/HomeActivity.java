package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
            FirstFrag firstFrag = new FirstFrag();
            manager.beginTransaction().replace(R.id.fragment_container1,firstFrag).commit();

        }

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.home:
                        fragment = new FirstFrag();
                        break;
                    case R.id.support:
                        fragment = new State_Wise_Filter();
                        break;
                    case R.id.favourite:
                        fragment = new SupportFragment();
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