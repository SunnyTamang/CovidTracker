package com.example.covidtracker;

public class DataModel {
    public String getCountry() {
        return country;
    }

    private String country;
    //private int cases;
    private int deaths;
    private int recovered;
    private int active;

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getActive() {
        return active;
    }

//    public int getCases() {
//
//        return cases;
//    }
}
