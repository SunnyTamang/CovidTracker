package com.trackc.trackc;

import com.trackc.trackc.Madal.LastUpdated;
import com.trackc.trackc.Madal.StateDataModel;
import com.trackc.trackc.Madal.WorldCardsModel;
import com.trackc.trackc.Madal.WorldDataList;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("v3/covid-19/countries")
    Call<List<WorldDataList>> getWorldTableData();


    @GET("v3/covid-19/all")
    Call<WorldCardsModel> getWorldCardsData(@Query("yesterday") boolean yesterday);

//    @GET("v3/covid-19/jhucsse")
//    Call<List<StateDataModel>> getWorldStateTableData();

    @GET("v3/covid-19/jhucsse")
    Call<List<StateDataModel>> getWorldStateCardsData();

    @GET("v3/covid-19/countries")
    Call<List<WorldDataList>> getWorldCountryNameCards();

    @GET("v3/covid-19/jhucsse")
    Call<List<LastUpdated>> getLastUpdated();




}
