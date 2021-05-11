package com.example.covidtracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covidtracker.Adapter.AutoCompleteCountryAdapter;
import com.example.covidtracker.Adapter.StateListAdapter;
import com.example.covidtracker.Adapter.StateListAdapterStateName;
import com.example.covidtracker.Madal.CountryItem;
import com.example.covidtracker.Madal.WorldDataList;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.internal.bind.ArrayTypeAdapter;

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
   // private ArrayList<ExampleItem> mExampleItem;
    private RecyclerView mRecyclerView;
    private List<CountryItem> countryList = new ArrayList<>();
    //private List<WorldDataList> countryList;

    RecyclerView state_list_rv;
    StateListAdapter stateListAdapter;
    StateListAdapterStateName stateListAdapterStateName;
    private ApiCall apiCall;
    //List<StateDataModel.Stats> dataResponse1;
    //List<StateDataModel> dataResponse;
    //Activity context;
    Context context;
    TextInputLayout select_location;

    AutoCompleteTextView location;
    ArrayList<CountryItem> arraList_Location;
    ArrayAdapter<String> arrayAdapter_location;
    AutoCompleteCountryAdapter adapter;
    //AutoCompleteTextView autoCompleteTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        view = inflater.inflate(R.layout.fragment_state_wise_filter, container, false);
        //autoCompleteTextView = view.findViewById(R.id.location);

//        state_list_rv = view.findViewById(R.id.state_list_rv);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
//        stateListAdapter = new StateListAdapter();
//        stateListAdapterStateName = new StateListAdapterStateName();
//        state_list_rv.setLayoutManager(manager);
//
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCall = retrofit.create(ApiCall.class);
        fetchingRecViewData();




        //autocomplete setup here

        //String []option = {"Egpt", "France","India"};
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.option_item,option);
//        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);
//        autoCompleteTextView.setAdapter(arrayAdapter);

        //This is woth customised spinner autocomplete textview
//        AutoCompleteTextView editCountryText = view.findViewById(R.id.location);
//        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(getContext(), countryList);
//        editCountryText.setAdapter(adapter);

        select_location=view.findViewById(R.id.select_location);
        location = view.findViewById(R.id.location);

        arraList_Location = new ArrayList<>();

//        arraList_Location.add("Egypt");
//        arraList_Location.add("France");
//        arraList_Location.add("India");
//        arraList_Location.add("Germany");

        adapter = new AutoCompleteCountryAdapter(getContext(),countryList);
        location.setAdapter(adapter);

        location.setThreshold(1);



        return view;
    }

    private void fetchingRecViewData() {
        Call<List<WorldDataList>> call = apiCall.getWorldTableData();



        call.enqueue(new Callback<List<WorldDataList>>() {
            @Override
            public void onResponse(Call<List<WorldDataList>> call, Response<List<WorldDataList>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), response.code(), Toast.LENGTH_SHORT).show();;
                    return;
                }

                List<WorldDataList> dataResponse = response.body();
                //countryList = new ArrayList<>();
                for (int p = 0 ; p< dataResponse.size();p++){
                    if( dataResponse.get(p) != null) {
                        countryList.add(new CountryItem(String.valueOf(dataResponse.get(p).getCountry())));
                    }
                    else
                        Log.d("State_Wise_Filter", "This is null");
                }



            }


            @Override
            public void onFailure(Call<List<WorldDataList>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

//        call2.enqueue(new Callback<StateDataModel.Stats>() {
//            @Override
//            public void onResponse(Call<StateDataModel.Stats> call, Response<StateDataModel.Stats> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(view.getContext(), response.code(), Toast.LENGTH_SHORT).show();;
//                    return;
//                }
//
//                //List<StateDataModel.Stats> dataResponse1 = response.body();
//                //stateListAdapter.setData(dataResponse1);
//                state_list_rv.setAdapter(stateListAdapter);
//
//
//            }
//
//
//            @Override
//            public void onFailure(Call<StateDataModel.Stats> call, Throwable t) {
//                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });


    }


}