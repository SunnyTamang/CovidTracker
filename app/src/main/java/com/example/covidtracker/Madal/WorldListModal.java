package com.example.covidtracker.Madal;

public class WorldListModal {
    private String countryName;
    private String totalAffected;
    private String totalRecovered;
    private String newAffected;
    private String totalDeath;
    public WorldListModal() {
    }

    public WorldListModal(String countryName, String totalAffected, String totalRecovered, String newAffected, String totalDeath) {
        this.countryName = countryName;
        this.totalAffected = totalAffected;
        this.totalRecovered = totalRecovered;
        this.newAffected = newAffected;
        this.totalDeath = totalDeath;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTotalAffected() {
        return totalAffected;
    }

    public void setTotalAffected(String totalAffected) {
        this.totalAffected = totalAffected;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getNewAffected() {
        return newAffected;
    }

    public void setNewAffected(String newAffected) {
        this.newAffected = newAffected;
    }

    public String getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(String totalDeath) {
        this.totalDeath = totalDeath;
    }
}
