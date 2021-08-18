package com.trackc.trackc;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trackc.trackc.Adapter.AutoCompleteCountryAdapter;
import com.trackc.trackc.Adapter.FetchData;
import com.trackc.trackc.Adapter.StateListAdapter;
import com.trackc.trackc.Adapter.StateListAdapterStateName;
import com.trackc.trackc.Madal.CountryItem;
import com.trackc.trackc.Madal.WorldDataList;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.textfield.TextInputLayout;

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
    public static String cName;
    int worldConfirmedCard;
    int active;
    int deceased;
    int recovered;
    int counter;
    private LineChart mChart;
    private LineChart mChart1;
    private LineChart mChart2;
    private static EditText search_s;

    private Button visualise;

    public static ArrayList<Integer> recoveredCount = new ArrayList<>();
    public static ArrayList<Date> historicDate = new ArrayList<>();
    private final ArrayList<String> histo = new ArrayList<>();

    public static ArrayList<Integer> confirmedCount = new ArrayList();


    public static ArrayList<Integer> deceasedCount = new ArrayList();
    DateFormat formatter = new SimpleDateFormat("M/d/yy");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void filter(String text) {
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

        recoveredCount.clear();
        confirmedCount.clear();
        deceasedCount.clear();

        view = inflater.inflate(R.layout.fragment_state_wise_filter, container, false);
        cName = null;


        //autoCompleteTextView = view.findViewById(R.id.location);

        visualise = view.findViewById(R.id.visualise);

        mChart = (LineChart) view.findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);



        mChart.setNoDataText("Please click on Visualize to visualize");

        mChart1 = (LineChart) view.findViewById(R.id.chart2);
        mChart1.getDescription().setEnabled(false);
        mChart1.setNoDataText("Please click on Visualize to visualize");

        mChart2 = (LineChart) view.findViewById(R.id.chart3);
        mChart2.getDescription().setEnabled(false);
        mChart2.setNoDataText("Please click on Visualize to visualize");




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

        select_location = view.findViewById(R.id.select_location);
        location = view.findViewById(R.id.location);

        location.setKeyListener(null);

        arraList_Location = new ArrayList<>();

//

        adapter = new AutoCompleteCountryAdapter(getContext(), countryList);
        location.setAdapter(adapter);

        location.setThreshold(1);


//        FetchData process = new FetchData();
//        process.execute();


        location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cName = location.getText().toString();

                recoveredCount.clear();
                confirmedCount.clear();
                deceasedCount.clear();
                Log.d("cName", cName);


                FetchData.locationSelected = cName;
                FetchData process = new FetchData();
                process.execute();


                counter = 0;
                getWorldCardsData();

                mChart.clear();
                mChart1.clear();
                mChart2.clear();


            }
        });



        visualise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if (cName != null) {
                    for (int i = 0; i < historicDate.size(); i++) {
                        histo.add(formatter.format(historicDate.get(i)));
                    }
                    setData();
                    setConfirmed();
                    setDeceased();
                    //visualise.setEnabled(false);




                } else {
                    Toast.makeText(view.getContext(), "Please select the location", Toast.LENGTH_SHORT).show();
                }


//                    recoveredCount.clear();
//                    confirmedCount.clear();
//                    deceasedCount.clear();




            }


        });


        return view;
    }


    private void setData() {
        counter=1;
        ArrayList<Entry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>();


        for (int i = 0; i < recoveredCount.size(); i++) {
            int value = recoveredCount.get(i);
            yVals.add(new BarEntry(i, value));
            //xVals.add(historicDate.get(i));
        }

        LineDataSet set = new LineDataSet(yVals, "Last 7 Days");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setDrawValues(true);
        set.setColor(Color.parseColor("#2DAA4A"));


        set.setValueTextSize(10f);


        XAxis xAxis = mChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return histo.get((int) value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);
        set.setDrawFilled(true);
        set.setFillAlpha(110);
        set.setLineWidth(1f);
        //set.setDrawCircles(true);
        set.setDrawCircleHole(false);
        set.setCircleColor(Color.parseColor("#2DAA4A"));
        set.setCircleRadius(4f);


        mChart.getAxisLeft().setEnabled(false);
        LineData data = new LineData(set);
        mChart.setData(data);
        mChart.fitScreen();
        mChart.setExtraLeftOffset(30);
        mChart.invalidate();
        // mChart.tex
        mChart.animateY(500);

    }

    private void setConfirmed() {
        ArrayList<Entry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>();


        for (int i = 0; i < confirmedCount.size(); i++) {
            Long value = Long.valueOf(confirmedCount.get(i));
            yVals.add(new BarEntry(Float.valueOf(i), value));
            //xVals.add(historicDate.get(i));
        }

        LineDataSet set = new LineDataSet(yVals, "Last 7 Days");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setColor(Color.parseColor("#ff6666"));


        XAxis xAxis = mChart1.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return histo.get((int) value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);
        set.setDrawFilled(true);
        set.setFillAlpha(110);
        set.setLineWidth(1f);
        //set.setDrawCircles(true);
        set.setDrawCircleHole(false);
        set.setCircleColor(Color.parseColor("#ff6666"));
        set.setCircleRadius(4f);


        mChart1.getAxisLeft().setEnabled(false);
        LineData data = new LineData(set);
        mChart1.setData(data);
        mChart1.invalidate();
        mChart1.setExtraLeftOffset(30);
        // mChart.tex
        mChart1.animateY(500);

    }

    private void setDeceased() {

        ArrayList<Entry> yVals = new ArrayList<>();
        //ArrayList<String> xVals = new ArrayList<>() ;

        for (int i = 0; i < deceasedCount.size(); i++) {
            Long value = Long.valueOf(deceasedCount.get(i));
            yVals.add(new Entry(Float.valueOf(i), value));
            //xVals.add(historicDate.get(i));
        }

        LineDataSet set = new LineDataSet(yVals, "Last 7 days");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setColor(Color.parseColor("#6D767E"));
        set.setDrawFilled(true);
        set.setFillAlpha(110);
        set.setLineWidth(1f);
        //set.setDrawCircles(true);
        set.setDrawCircleHole(false);
        set.setCircleRadius(4f);


        XAxis xAxis = mChart2.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return histo.get((int) value);
            }
        });


        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);


        LineData data = new LineData(set);


        mChart2.getAxisLeft().setEnabled(false);

        mChart2.setData(data);

        mChart2.invalidate();
        mChart2.setExtraLeftOffset(30);
        // mChart.tex
        mChart2.animateY(500);

    }


    private void fetchingRecViewData() {
        Call<List<WorldDataList>> call = apiCall.getWorldTableData();


        call.enqueue(new Callback<List<WorldDataList>>() {
            @Override
            public void onResponse(Call<List<WorldDataList>> call, Response<List<WorldDataList>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), "Seems there is issue with the server. Please try after sometimes", Toast.LENGTH_LONG).show();
                    return;
                }

                List<WorldDataList> dataResponse = response.body();
                //countryList = new ArrayList<>();
                for (int p = 0; p < dataResponse.size(); p++) {
                    if (dataResponse.get(p) != null) {
                        countryList.add(new CountryItem(String.valueOf(dataResponse.get(p).getCountry())));
                    }
                }


            }


            @Override
            public void onFailure(Call<List<WorldDataList>> call, Throwable t) {
                Toast.makeText(view.getContext(), "There seems to be issue with connectivity. Please check your internet connection and try again!", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void getWorldCardsData() {


        Call<List<WorldDataList>> call = apiCall.getWorldCountryNameCards();


        call.enqueue(new Callback<List<WorldDataList>>() {
            @Override
            public void onResponse(Call<List<WorldDataList>> call, Response<List<WorldDataList>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(view.getContext(), "Seems there is issue with the server. Please try after sometimes", Toast.LENGTH_LONG).show();
                    return;
                }

//

                //--------------------------------------This is added from the world API------------------------------------------//

                List<WorldDataList> countryDataResponse = response.body();
                //countryList = new ArrayList<>();

                for (WorldDataList list : countryDataResponse) {
                    if (list.getCountry().equals(cName)) {
                        worldConfirmedCard = list.getCases();
                        active = list.getActive();
                        deceased = list.getDeaths();
                        recovered = list.getRecovered();
                    }
                }
//


                confirmed_count.setText(String.valueOf(worldConfirmedCard));
                active_count.setText(String.valueOf(active));
                deceased_count.setText(String.valueOf(deceased));
                recovered_count.setText(String.valueOf(recovered));
            }


            @Override
            public void onFailure(Call<List<WorldDataList>> call, Throwable t) {
                Toast.makeText(view.getContext(), "There seems to be issue with connectivity. Please check your internet connection and try again!", Toast.LENGTH_LONG).show();
            }
        });
    }


}