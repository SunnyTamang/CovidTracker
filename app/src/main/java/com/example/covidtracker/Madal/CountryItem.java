package com.example.covidtracker.Madal;

public class CountryItem {

    private String countryName;

    public CountryItem(String countryName){
        this.countryName = countryName;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
