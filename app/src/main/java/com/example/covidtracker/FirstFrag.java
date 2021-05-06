package com.example.covidtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidtracker.Adapter.WorldListAdapter;
import com.example.covidtracker.Madal.WorldCardsModel;
import com.example.covidtracker.Madal.WorldDataList;
import com.example.covidtracker.Madal.WorldListModal;
import com.example.covidtracker.Utils.ApiClients;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    private TextView confirmed_count;
    private TextView active_count;
    private TextView deceased_count;
    private TextView recovered_count;
    private int sum=0;
    private ApiCall apiCall;
    RecyclerView world_list_rv;
    Activity context;
    WorldListAdapter worldListAdapter;
    private List<WorldDataList> mExampleList = new ArrayList<>();

    //private WorldListAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_splash_test,container,false);
        world_list_rv = view.findViewById(R.id.world_list_rv);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        worldListAdapter = new WorldListAdapter();
        world_list_rv.setLayoutManager(manager);
        worldListAdapter.setOnItemClickListener(new WorldListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(view.getContext(), "wow", Toast.LENGTH_SHORT).show();
                Fragment stateWiseFragment = new State_Wise_Filter();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container1,stateWiseFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


       // fetchingRvData();





        //
        confirmed_count = view.findViewById(R.id.confirmed_count);
        active_count = view.findViewById(R.id.active_count);
        deceased_count = view.findViewById(R.id.deceased_count);
        recovered_count = view.findViewById(R.id.recovered_count);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCall = retrofit.create(ApiCall.class);
        //Call<DataModel> call = apiCall.getData();
        //--------------------------------------This is added from the world API------------------------------------------//
        getWorldCardsData();
        fetchingRecViewData();



        EditText editText = view.findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return view;
    }

//For search Filter
    private void filter(String text) {
        ArrayList<WorldDataList> filteredList = new ArrayList<>();

        for (WorldDataList item : mExampleList) {
            if (item.getCountry().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        worldListAdapter.filterList(filteredList);
    }

    private void fetchingRecViewData() {
        Call<List<WorldDataList>> call = apiCall.getWorldTableData();


        call.enqueue(new Callback<List<WorldDataList>>() {
            @Override
            public void onResponse(Call<List<WorldDataList>> call, Response<List<WorldDataList>> response) {
                if (!response.isSuccessful()) {
                    confirmed_count.setText(response.code());
                    return;
                }


                List<WorldDataList> dataResponse = response.body();

                for(WorldDataList list : response.body()){
                    mExampleList.add(list);
                }
                worldListAdapter.setData(dataResponse);
                world_list_rv.setAdapter(worldListAdapter);
            }


            @Override
            public void onFailure(Call<List<WorldDataList>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



    private void getWorldCardsData(){
        Call<WorldCardsModel> call = apiCall.getWorldCardsData(false);


        call.enqueue(new Callback<WorldCardsModel>() {
            @Override
            public void onResponse(Call<WorldCardsModel> call, Response<WorldCardsModel> response) {
                if (!response.isSuccessful()) {
                    confirmed_count.setText(response.code());
                    return;
                }

//                int confirmed = response.body().getCases();
//                int active = response.body().getActive();
//                int deceased = response.body().getDeaths();
//                int recovered = response.body().getRecovered();
//
//                confirmed_count.append(String.valueOf(confirmed));
//                active_count.append(String.valueOf(active));
//                deceased_count.append(String.valueOf(deceased));
//                recovered_count.append(String.valueOf(recovered));

                //--------------------------------------This is added from the world API------------------------------------------//

                int worldConfirmedCard = response.body().getCases();
                int active = response.body().getActive();
                int deceased = response.body().getDeaths();
                int recovered = response.body().getRecovered();

                confirmed_count.append(String.valueOf(worldConfirmedCard));
                active_count.append(String.valueOf(active));
                deceased_count.append(String.valueOf(deceased));
                recovered_count.append(String.valueOf(recovered));
            }


            @Override
            public void onFailure(Call<WorldCardsModel> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }




}