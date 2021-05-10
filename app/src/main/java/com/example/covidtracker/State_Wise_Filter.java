package com.example.covidtracker;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.covidtracker.Adapter.StateListAdapter;
import com.example.covidtracker.Adapter.StateListAdapterStateName;
import com.google.gson.internal.bind.ArrayTypeAdapter;

public class State_Wise_Filter extends Fragment {


//    public State_Wise_Filter() {
//        // Required empty public constructor
//    }

    View view;
   // private ArrayList<ExampleItem> mExampleItem;
    private RecyclerView mRecyclerView;

    RecyclerView state_list_rv;
    StateListAdapter stateListAdapter;
    StateListAdapterStateName stateListAdapterStateName;
    private ApiCall apiCall;
    //List<StateDataModel.Stats> dataResponse1;
    //List<StateDataModel> dataResponse;
    Activity context;


    AutoCompleteTextView autoCompleteTextView;
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
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://disease.sh/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        apiCall = retrofit.create(ApiCall.class);
        //fetchingRecViewData();

        //Edit Text ka kaam

        createExampleList();
        buildRecyclerView();

        EditText editText = view.findViewById(R.id.edittext);

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
//

        //autocomplete setup here

        String []option = {"Egpt", "France","India"};
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.option_item,option);
//        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);
//        autoCompleteTextView.setAdapter(arrayAdapter);



        return view;
    }

    private void fetchingRecViewData() {
       // Call<List<StateDataModel>> call = apiCall.getWorldStateTableData();
        //Call<StateDataModel.Stats> call2 = apiCall.getWorldStateCardsData();


//        call.enqueue(new Callback<List<StateDataModel>>() {
//            @Override
//            public void onResponse(Call<List<StateDataModel>> call, Response<List<StateDataModel>> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(view.getContext(), response.code(), Toast.LENGTH_SHORT).show();;
//                    return;
//                }
//
//                List<StateDataModel> dataResponse = response.body();
//                stateListAdapterStateName.setData(dataResponse);
//                state_list_rv.setAdapter(stateListAdapter);
//
//
//
//            }
//
//
//            @Override
//            public void onFailure(Call<List<StateDataModel>> call, Throwable t) {
//                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

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