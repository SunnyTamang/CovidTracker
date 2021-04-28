package com.example.covidtracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


public class FirstFrag extends Fragment {

    NavController navController;
    Button world_btn;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_first,container,false);


        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        navController = Objects.requireNonNull(navHostFragment).getNavController();
//        world_btn = view.findViewById(R.id.worldbutton);
//        TextView textView=view.findViewById(R.id.datetext);
//
//
//        // ClickListner to communicate one fragment to second fragment
//        world_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                navController.navigate(R.id.first_fragment_to_second_fragment,bundle);
//
//            }
//        });




//                Date date = new Date();
//        String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
//        String day          = (String) DateFormat.format("dd",   date); // 20
//        String monthString  = (String) DateFormat.format("MMMM",  date); // Jun
//        TextView textView=view.findViewById(R.id.datetext);
//        textView.setText(dayOfTheWeek + ", " + day + "\n" + monthString);

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        //textView.setText(formattedDate);
        return view;
    }


}