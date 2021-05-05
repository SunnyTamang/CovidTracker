package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StateWiseDataActivity extends AppCompatActivity {
    TextView countryName;
    TextView confirmed_count;
    TextView active_cases;
    TextView recovered_count;
    TextView deceased_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_wise_data);

        countryName = findViewById(R.id.countyName);
        confirmed_count = findViewById(R.id.confirmed_Count);
        active_cases = findViewById(R.id.active_count);
        recovered_count = findViewById(R.id.recovered_count);
        deceased_count = findViewById(R.id.deceased_count);

        String c_Name = getIntent().getExtras().getString("Country Name");
        String C_count = getIntent().getStringExtra("Total Confirmed");
        String A_cases = getIntent().getExtras().getString("Total Active");
        String R_count = getIntent().getExtras().getString("CountryRecovered");
        String D_count = getIntent().getExtras().getString("Total Deceased");

        countryName.setText(c_Name);
        confirmed_count.setText(C_count);
        active_cases.setText(A_cases);
        recovered_count.setText(R_count);
        deceased_count.setText(D_count);

    }
}