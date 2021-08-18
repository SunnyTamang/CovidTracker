package com.trackc.trackc.Madal;

public class Stats {
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


    public Stats(Long confirmed, Long deaths, Long recovered) {
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }
}
