package com.example.covidtracker;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {

    //pass in the sub URL not the base URL
    @GET("countries/India")
    Call<DataModel> getData();
}
