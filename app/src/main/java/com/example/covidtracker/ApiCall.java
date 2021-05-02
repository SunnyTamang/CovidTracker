package com.example.covidtracker;

import com.example.covidtracker.Madal.WorldCardsModel;
import com.example.covidtracker.Madal.WorldListModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    @GET("v3/covid-19/countries")
    //Call<DataModel> getData();
    // -------------This was added from world API ----------//
    Call<List<WorldListModal>> getWorldTableData();

    @GET("v3/covid-19/all")
    Call<WorldCardsModel> getWorldCardsData();


}
