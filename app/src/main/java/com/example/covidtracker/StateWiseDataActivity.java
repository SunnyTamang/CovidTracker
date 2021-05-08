package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidtracker.Adapter.StateListAdapter;
import com.example.covidtracker.Adapter.StateListAdapterStateName;
import com.example.covidtracker.Madal.StateDataModel;
import com.example.covidtracker.Madal.WorldDataList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StateWiseDataActivity extends AppCompatActivity {

    private static final String TAG = "StateWiseDataActivity";
    TextView countryName;
    TextView confirmed_count;
    TextView active_cases;
    TextView recovered_count;
    TextView deceased_count;

    String c_Name="";
    String C_count="";
    String A_cases="";
    String R_count="";
    String D_count="";

    private List listOfData = new ArrayList<>();
    private List listOfConfirmed = new ArrayList<>();
    private List listOfRecovered = new ArrayList<>();
    private List listOfDeceased = new ArrayList<>();
    private List listOfActive = new ArrayList<>();

    RecyclerView state_list_rv;
    StateListAdapter stateListAdapter;
    StateListAdapterStateName stateListAdapterStateName;
    private ApiCall apiCall;

    private List<StateDataModel> mStateFilteredList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_wise_data);

        countryName = findViewById(R.id.countyName);
        confirmed_count = findViewById(R.id.confirmed_Count);
        active_cases = findViewById(R.id.active_count);
        recovered_count = findViewById(R.id.recovered_count);
        deceased_count = findViewById(R.id.deceased_count);


        c_Name = getIntent().getExtras().getString("Country Name");
        C_count = getIntent().getStringExtra("Total Confirmed");
        A_cases = getIntent().getExtras().getString("Total Active");
        R_count = getIntent().getExtras().getString("CountryRecovered");
        D_count = getIntent().getExtras().getString("Total Deceased");

        countryName.setText(c_Name);
        confirmed_count.setText(C_count);
        active_cases.setText(A_cases);
        recovered_count.setText(R_count);
        deceased_count.setText(D_count);


        //Retrofit


        state_list_rv = findViewById(R.id.state_list_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        stateListAdapter = new StateListAdapter();
        stateListAdapterStateName = new StateListAdapterStateName();
        state_list_rv.setLayoutManager(manager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCall = retrofit.create(ApiCall.class);
        //fetchingRecViewData();
        fetchingStateViewData();

        EditText editText = findViewById(R.id.searchState);
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

    private void filter(String text) {
        List filteredList = new ArrayList<>();
        List nullFiltration = new ArrayList<>();

        for (int k = 0; k < listOfData.size(); k++) {

            if (listOfData.get(k) != null ){
                nullFiltration.add(listOfData.get(k));
            }

        }
        if(nullFiltration.size() == 0){
            Toast.makeText(this, "There is province data", Toast.LENGTH_SHORT).show();

        }
        else {
            for (int k = 0; k < nullFiltration.size(); k++) {
//            if (nullFiltration.get(k).getProvince() == null ){
//                Log.d(TAG, "This is null");
//
//                //filteredList.add();
//            }
//            else
                if(nullFiltration.get(k).toString().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(nullFiltration.get(k));

                }

                List<StateDataModel> searchState = filteredList;




                //stateListAdapterStateName.filterList(filteredList);

                stateListAdapterStateName.setData(searchState,listOfConfirmed,listOfRecovered,listOfDeceased,listOfActive);
                state_list_rv.setAdapter(stateListAdapterStateName);

            }

        }


    }

    private void fetchingStateViewData() {

       Call<List<StateDataModel>> call2 = apiCall.getWorldStateCardsData();


        call2.enqueue(new Callback<List<StateDataModel>>() {
            @Override
            public void onResponse(Call<List<StateDataModel>> call, Response<List<StateDataModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<StateDataModel> Posts = response.body();

                //Adding in the list to ssearch after
                for(StateDataModel list : response.body()){
                    mStateFilteredList.add(list);
                }

                for(int i = 0 ; i < Posts.size(); i++){
                    if (Posts.get(i).getCountry().equals(c_Name)){
                        Log.d(TAG, "confirmed: " + Posts.get(i).getCountry());
                        listOfConfirmed.add(Posts.get(i).getStats().getConfirmed());
                        listOfRecovered.add(Posts.get(i).getStats().getRecovered());
                        listOfDeceased.add(Posts.get(i).getStats().getDeaths());
                        listOfActive.add((Posts.get(i).getStats().getConfirmed() - Posts.get(i).getStats().getRecovered() - Posts.get(i).getStats().getDeaths()));
                        listOfData.add(Posts.get(i).getProvince());
                    }
                }
//                List<StateDataModel> data_add_all = new ArrayList<>();
//                data_add_all.addAll(listOfConfirm);
                //List<StateDataModel.Stats> list = dataResponse1


                List<StateDataModel> confirmedCount = listOfConfirmed;
                List<StateDataModel> recoveredCount = listOfRecovered;
                List<StateDataModel> deceasedCount = listOfDeceased;
                List<StateDataModel> activeCount = listOfActive;

                List<StateDataModel> dataResponse = listOfData;


//                stateListAdapter.setData(dataResponse1);
//                state_list_rv.setAdapter(stateListAdapter);
                for (int i=0;i<listOfData.size();i++){
                    if(listOfData.get(i) != null){
                        stateListAdapterStateName.setData(dataResponse,confirmedCount,recoveredCount, deceasedCount, activeCount);
                        state_list_rv.setAdapter(stateListAdapterStateName);
                    }
                    else
                        Toast.makeText(StateWiseDataActivity.this, "Province data is not available for " + c_Name, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<StateDataModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // This method is deactivated for testing purpose

    private void fetchingRecViewData() {
        //Call<List<StateDataModel>> call = apiCall.getWorldStateTableData();

        Call<List<StateDataModel>> call = apiCall.getWorldStateCardsData();



        call.enqueue(new Callback<List<StateDataModel>>() {
            @Override
            public void onResponse(Call<List<StateDataModel>> call, Response<List<StateDataModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();;
                    return;
                }

                List<StateDataModel> feeds = response.body();
                for(int j=0;j<feeds.size();j++){
                    if(feeds.get(j).getCountry().equals(c_Name)){
                        //Toast.makeText(StateWiseDataActivity.this,c_Name, Toast.LENGTH_SHORT).show();
                        listOfData.add(feeds.get(j).getProvince());
                    }
                }
                List<StateDataModel> dataResponse = listOfData;
               // stateListAdapterStateName.setData(dataResponse);
                state_list_rv.setAdapter(stateListAdapterStateName);



            }


            @Override
            public void onFailure(Call<List<StateDataModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });




    }
}