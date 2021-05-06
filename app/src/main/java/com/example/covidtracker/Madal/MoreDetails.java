package com.example.covidtracker.Madal;

import android.util.Log;

public class MoreDetails {
    private Long confirmed;
    private Long deaths;
    private Long recovered;

    //Getters


    public Long getConfirmed() {
        return confirmed;
    }

    public Long getDeaths() {
        return deaths;
    }

    public Long getRecovered() {
        return recovered;
    }

    //Constructor


    public MoreDetails(Long confirmed, Long deaths, Long recovered) {
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }
}
