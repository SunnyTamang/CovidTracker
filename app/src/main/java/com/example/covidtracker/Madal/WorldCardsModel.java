package com.example.covidtracker.Madal;

public class WorldCardsModel {

    private long updated;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int todayRecovered;
    private int active;
    private int critical;
    private double casesPerOneMillion;
    private double deathsPerOneMillion;
    private long tests;
    private double testsPerOneMillion;
    private long population;
    private double oneCasePerPeople;
    private double oneDeathPerPeople;
    private double oneTestPerPeople;
    private double undefined;
    private double activePerOneMillion;
    private double recoveredPerOneMillion;
    private double criticalPerOneMillion;
    private int affectedCountries;

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(double deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getTests() {
        return tests;
    }

    public void setTests(long tests) {
        this.tests = tests;
    }

    public double getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(double testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(int oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public double getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(int oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public double getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(int oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public double getUndefined() {
        return undefined;
    }

    public void setUndefined(int undefined) {
        this.undefined = undefined;
    }

    public double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(double activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(double recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(double criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public int getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(int affectedCountries) {
        this.affectedCountries = affectedCountries;
    }
}
