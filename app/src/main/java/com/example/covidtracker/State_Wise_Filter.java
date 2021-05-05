package com.example.covidtracker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covidtracker.Adapter.StateListAdapter;
import com.example.covidtracker.Adapter.WorldListAdapter;
import com.example.covidtracker.Madal.StateDataModel;
import com.example.covidtracker.Madal.WorldDataList;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class State_Wise_Filter extends Fragment {


//    public State_Wise_Filter() {
//        // Required empty public constructor
//    }

    View view;
   // private ArrayList<ExampleItem> mExampleItem;
    private RecyclerView mRecyclerView;
    private PieChart pieChart;
    RecyclerView state_list_rv;
    StateListAdapter stateListAdapter;
    private ApiCall apiCall;
    List<StateDataModel.Stats> dataResponse1;
    List<StateDataModel> dataResponse;
    Activity context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createExampleList();
        buildRecyclerView();

        EditText editText = view.findViewById(R.id.search_state);

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
    }
    private void filter(String text){
       // ArrayList<ExampleItem>
    }

    private void createExampleList() {

    }

    private void buildRecyclerView() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_state_wise_data, container, false);
        state_list_rv = view.findViewById(R.id.state_list_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        stateListAdapter = new StateListAdapter();
        state_list_rv.setLayoutManager(manager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCall = retrofit.create(ApiCall.class);
        fetchingRecViewData();

        return view;
    }

    private void fetchingRecViewData() {
        Call<List<StateDataModel>> call = apiCall.getWorldStateTableData();
        Call<List<StateDataModel.Stats>> call2 = apiCall.getWorldStateCardsData();


        call.enqueue(new Callback<List<StateDataModel>>() {
            @Override
            public void onResponse(Call<List<StateDataModel>> call, Response<List<StateDataModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), response.code(), Toast.LENGTH_SHORT).show();;
                    return;
                }

                List<StateDataModel> dataResponse = response.body();




            }


            @Override
            public void onFailure(Call<List<StateDataModel>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        call2.enqueue(new Callback<List<StateDataModel.Stats>>() {
            @Override
            public void onResponse(Call<List<StateDataModel.Stats>> call, Response<List<StateDataModel.Stats>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), response.code(), Toast.LENGTH_SHORT).show();;
                    return;
                }

                List<StateDataModel.Stats> dataResponse1 = response.body();



            }


            @Override
            public void onFailure(Call<List<StateDataModel.Stats>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        stateListAdapter.setData(dataResponse,dataResponse1);
        state_list_rv.setAdapter(stateListAdapter);
    }


}