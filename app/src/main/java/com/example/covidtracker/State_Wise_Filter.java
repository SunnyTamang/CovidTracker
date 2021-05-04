package com.example.covidtracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidtracker.Madal.StateDataModel;
import com.example.covidtracker.Madal.WorldCardsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class State_Wise_Filter extends Fragment {


//    public State_Wise_Filter() {
//        // Required empty public constructor
//    }

    View view;
    EditText editText;
    //private ArrayList<ExampleItem> mExampleItem;
    private RecyclerView mRecyclerView;
    private TextView confirmed_count;
    private TextView active_count;
    private TextView deceased_count;
    private TextView recovered_count;
    private int sum=0;
    private ApiCall apiCall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        createExampleList();
//        buildRecyclerView();
//
//        EditText editText = view.findViewById(R.id.search_state);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });
    }
//    private void filter(String text){
//       // ArrayList<ExampleItem>
//    }
//
//    private void createExampleList() {
//
//    }
//
//    private void buildRecyclerView() {
//
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_state__wise__filter, container, false);

        confirmed_count = view.findViewById(R.id.confirmed_count);
        active_count = view.findViewById(R.id.active_count);
        deceased_count = view.findViewById(R.id.deceased_count);
        recovered_count = view.findViewById(R.id.recovered_count);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCall = retrofit.create(ApiCall.class);

        getWorldCardsData();
        return view;

    }

    private void getWorldCardsData() {
        Call<StateDataModel.Stats> call = apiCall.getWorldStateCardsData();


        call.enqueue(new Callback<StateDataModel.Stats>() {
            @Override
            public void onResponse(Call<StateDataModel.Stats> call, Response<StateDataModel.Stats> response) {
                if (!response.isSuccessful()) {
                    confirmed_count.setText(response.code());
                    return;
                }

                int activeCases = response.body().getConfirmed()  - response.body().getRecovered() - response.body().getDeaths();
                int worldConfirmedCard = response.body().getConfirmed();
                int active = activeCases;
                int deceased = response.body().getDeaths();
                int recovered = response.body().getRecovered();

                confirmed_count.append(String.valueOf(worldConfirmedCard));
                active_count.append(String.valueOf(active));
                deceased_count.append(String.valueOf(deceased));
                recovered_count.append(String.valueOf(recovered));
            }


            @Override
            public void onFailure(Call<StateDataModel.Stats> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}