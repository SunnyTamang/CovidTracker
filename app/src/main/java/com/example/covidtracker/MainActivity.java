package com.example.covidtracker;
import android.text.format.DateFormat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    Button btn_world;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date date = new Date();
        String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
        String day          = (String) DateFormat.format("dd",   date); // 20
        String monthString  = (String) DateFormat.format("MMMM",  date); // Jun
        TextView textView=findViewById(R.id.datetext);
        textView.setText(dayOfTheWeek + ", " + day + "\n" + monthString);

//        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        btn_world = findViewById(R.id.worldbutton);

        btn_world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SecondFrag secondFrag = new SecondFrag();
//                fragmentTransaction.replace(R.id.fragment_container,secondFrag);
//                fragmentTransaction.commit();
                replaceFragment(new FirstFrag());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }


}