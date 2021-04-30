package com.example.covidtracker;

import java.util.Dictionary;

public class DataModel {
    // This DataModel will be in the format we want out data to be

    private long deaths;
    private long recovered;
    private long active;

    private long updated;
    private String country;

    private Dictionary countryInfo;
    private int cases;
    private long todayCases;

    private long todayDeaths;

    private long todayRecovered;

    private long critical;
    private long casesPerOneMillion;
    private long deathsPerOneMillion;
    private long tests;
    private long testsPerOneMillion;
    private long population;
    private String continent;
    private long oneCasePerPeople;
    private long oneDeathPerPeople;
    private long oneTestPerPeople;
    private long undefined;
    private long activePerOneMillion;
    private long recoveredPerOneMillion;
    private long criticalPerOneMillion;


    public long getDeaths() {
        return deaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public long getActive() {
        return active;
    }

    public long getUpdated() {
        return updated;
    }

    public String getCountry() {
        return country;
    }

    public Dictionary getCountryInfo() {
        return countryInfo;
    }

    public int getCases() {
        return cases;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public long getTodayRecovered() {
        return todayRecovered;
    }

    public long getCritical() {
        return critical;
    }

    public long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public long getTests() {
        return tests;
    }

    public long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public long getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public long getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public long getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public long getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public long getUndefined() {
        return undefined;
    }

    public long getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public long getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public long getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }
}
