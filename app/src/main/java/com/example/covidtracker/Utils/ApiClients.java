package com.example.covidtracker.Utils;

import com.example.covidtracker.ApiCall;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClients {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.larntech.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }


    public static ApiCall getUserService(){
        ApiCall userService = getRetrofit().create(ApiCall.class);
        return userService;
    }

}
