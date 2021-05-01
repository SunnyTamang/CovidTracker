package com.example.covidtracker;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidtracker.Adapter.WorldListAdapter;
import com.example.covidtracker.Madal.WorldListModal;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FirstFrag extends Fragment {

    NavController navController;
    Button world_btn;
    View view;
    TextView confirm;
    int jsonData;

    private TextView confirmed_count;
    private TextView active_count;
    private TextView deceased_count;
    private TextView recovered_count;
    RecyclerView world_list_rv;
    List<WorldListModal> worldListModalList = new ArrayList<>();
    Activity context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WorldListModal modalCurrentItem = new WorldListModal();
        modalCurrentItem.setCountryName("India");
        modalCurrentItem.setNewAffected("34234");
        modalCurrentItem.setTotalAffected("34234");
        modalCurrentItem.setTotalDeath("52");
        modalCurrentItem.setTotalRecovered("56516");
        for (int i = 0; i<10;i++){
            worldListModalList.add(modalCurrentItem);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_splash_test,container,false);
        world_list_rv = view.findViewById(R.id.world_list_rv);
        WorldListAdapter adapter = new WorldListAdapter(worldListModalList,context);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        world_list_rv.setLayoutManager(manager);
        world_list_rv.setAdapter(adapter);


//        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//        navController = Objects.requireNonNull(navHostFragment).getNavController();
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

        Spinner spinner = (Spinner) view.findViewById(R.id.country_spinner);

        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.dummy_date,
                android.R.layout.simple_list_item_1);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


        //
        confirmed_count = view.findViewById(R.id.confirmed_count);
        active_count = view.findViewById(R.id.active_count);
        deceased_count = view.findViewById(R.id.deceased_count);
        recovered_count = view.findViewById(R.id.recovered_count);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiCall apiCall = retrofit.create(ApiCall.class);
        Call<DataModel> call = apiCall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (!response.isSuccessful()) {
                    confirmed_count.setText(response.code());
                    return;
                }

                int confirmed = response.body().getCases();
                int active = response.body().getActive();
                int deceased = response.body().getDeaths();
                int recovered = response.body().getRecovered();

                confirmed_count.append(String.valueOf(confirmed));
                active_count.append(String.valueOf(active));
                deceased_count.append(String.valueOf(deceased));
                recovered_count.append(String.valueOf(recovered));

            }


            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                confirmed_count.setText(t.getMessage());
            }
        });


        return view;
    }


}