package com.example.covidtracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidtracker.Adapter.AutoCompleteCountryAdapter;
import com.example.covidtracker.Adapter.FetchData;
import com.example.covidtracker.Adapter.StateListAdapter;
import com.example.covidtracker.Adapter.StateListAdapterStateName;
import com.example.covidtracker.Madal.CountryItem;
import com.example.covidtracker.Madal.WorldCardsModel;
import com.example.covidtracker.Madal.WorldDataList;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.internal.bind.ArrayTypeAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private TextView confirmed_count;
    private TextView active_count;
    private TextView deceased_count;
    private TextView recovered_count;
    String cName;
    int worldConfirmedCard;
    int active;
    int deceased;
    int recovered;
    int counter;
    private BarChart mChart;
    private BarChart mChart1;
    private BarChart mChart2;
    private static EditText search_s;

    public static ArrayList<Integer> recoveredCount=new ArrayList<>();
    public static ArrayList<Date> historicDate=new ArrayList<>();
    private final ArrayList<String> histo = new ArrayList<>();

    public static ArrayList<Integer> confirmedCount=new ArrayList();


    public static ArrayList<Integer> deceasedCount=new ArrayList();
    DateFormat formatter = new SimpleDateFormat("M/d/yy");



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
        mChart= (BarChart)view.findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);

        mChart1=(BarChart) view.findViewById(R.id.chart2);
        mChart1.getDescription().setEnabled(false);

        mChart2=(BarChart) view.findViewById(R.id.chart3);
        mChart2.getDescription().setEnabled(false);
//        state_list_rv = view.findViewById(R.id.state_list_rv);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
//        stateListAdapter = new StateListAdapter();
//        stateListAdapterStateName = new StateListAdapterStateName();
//        state_list_rv.setLayoutManager(manager);
//
        FetchData process = new FetchData();
        process.execute();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://disease.sh/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCall = retrofit.create(ApiCall.class);
        fetchingRecViewData();




        confirmed_count = view.findViewById(R.id.confirmed_count);
        active_count = view.findViewById(R.id.active_count);
        deceased_count = view.findViewById(R.id.deceased_count);
        recovered_count = view.findViewById(R.id.recovered_count);


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




        location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cName = location.getText().toString();

                counter = 0;
                getWorldCardsData();



                for (int i=0 ;i < historicDate.size();i++){
                    histo.add(formatter.format(historicDate.get(i)));
                }
                Log.d("Histo", histo.toString());




                if(counter == 0){
                    setData();
                    setConfirmed();
                    setDeceased();

                    counter += 1;
                }
                //getGraph();


                //mChart.setFitBars(true);
            }
        });



        return view;
    }

    private void setData() {
        ArrayList<BarEntry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>() ;



        for(int i= 0; i<recoveredCount.size();i++){
            int value = recoveredCount.get(i);
            yVals.add(new BarEntry(i, value));
            //xVals.add(historicDate.get(i));
        }

        BarDataSet set = new BarDataSet(yVals,"Last 7 Days");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setDrawValues(false);
        set.setColor(Color.parseColor("#2DAA4A"));


        //set.setValueTextSize(15f);


        XAxis xAxis = mChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return histo.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);



        BarData data = new BarData(set);
        mChart.setData(data);
        mChart.invalidate();
        // mChart.tex
        mChart.animateY(500);

    }

    private void setConfirmed(){
        ArrayList<BarEntry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>() ;




        for(int i= 0; i<confirmedCount.size();i++){
            Long value = Long.valueOf(confirmedCount.get(i));
            yVals.add(new BarEntry(Float.valueOf(i), value));
            //xVals.add(historicDate.get(i));
        }

        BarDataSet set = new BarDataSet(yVals,"Last 7 Days");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setDrawValues(false);
        //set.setValueTextSize(12f);
        set.setColor(Color.parseColor("#ff6666"));


        XAxis xAxis = mChart1.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return histo.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);



        BarData data = new BarData(set);
        mChart1.setData(data);
        mChart1.invalidate();
        // mChart.tex
        mChart1.animateY(500);

    }

    private void setDeceased(){
        ArrayList<BarEntry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>() ;




        for(int i= 0; i<deceasedCount.size();i++){
            Long value = Long.valueOf(deceasedCount.get(i));
            yVals.add(new BarEntry(Float.valueOf(i), value));
            //xVals.add(historicDate.get(i));
        }

        BarDataSet set = new BarDataSet(yVals,"Last 7 Days");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setDrawValues(false);
        //set.setValueTextSize(12f);
        set.setColor(Color.parseColor("#6D767E"));


        XAxis xAxis = mChart2.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return histo.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);



        BarData data = new BarData(set);
        mChart2.setData(data);
        mChart2.invalidate();
        // mChart.tex
        mChart2.animateY(500);

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



    }

    private void getWorldCardsData(){


        Call<List<WorldDataList>> call = apiCall.getWorldCountryNameCards();


        call.enqueue(new Callback<List<WorldDataList>>() {
            @Override
            public void onResponse(Call<List<WorldDataList>> call, Response<List<WorldDataList>> response) {
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

                List<WorldDataList> countryDataResponse = response.body();
                //countryList = new ArrayList<>();

                for (WorldDataList list : countryDataResponse){
                    if(list.getCountry().equals(cName) ){
                        worldConfirmedCard = list.getCases();
                        active = list.getActive();
                        deceased = list.getDeaths();
                        recovered = list.getRecovered();
                    }
                    else
                        Log.d("matching",list.getCountry());
                }
//



                confirmed_count.setText(String.valueOf(worldConfirmedCard));
                active_count.setText(String.valueOf(active));
                deceased_count.setText(String.valueOf(deceased));
                recovered_count.setText(String.valueOf(recovered));
            }


            @Override
            public void onFailure(Call<List<WorldDataList>> call, Throwable t) {
                Toast.makeText(view.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}