package com.example.covidtracker;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    @GET("v3/covid-19/countries/India")
    Call<DataModel> getData();
}
