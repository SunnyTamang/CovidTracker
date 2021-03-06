package com.example.covidtracker.Madal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorldDataList {
        @SerializedName("updated")
        @Expose
        private Long updated;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("cases")
        @Expose
        private Integer cases;
        @SerializedName("todayCases")
        @Expose
        private Integer todayCases;
        @SerializedName("deaths")
        @Expose
        private Integer deaths;
        @SerializedName("todayDeaths")
        @Expose
        private Integer todayDeaths;
        @SerializedName("recovered")
        @Expose
        private Integer recovered;
        @SerializedName("todayRecovered")
        @Expose
        private Integer todayRecovered;
        @SerializedName("active")
        @Expose
        private Integer active;
        @SerializedName("critical")
        @Expose
        private Integer critical;
        @SerializedName("casesPerOneMillion")
        @Expose
        private Double casesPerOneMillion;
        @SerializedName("deathsPerOneMillion")
        @Expose
        private Double deathsPerOneMillion;
        @SerializedName("tests")
        @Expose
        private Integer tests;
        @SerializedName("testsPerOneMillion")
        @Expose
        private Double testsPerOneMillion;
        @SerializedName("population")
        @Expose
        private Integer population;
        @SerializedName("continent")
        @Expose
        private String continent;
        @SerializedName("oneCasePerPeople")
        @Expose
        private Double oneCasePerPeople;
        @SerializedName("oneDeathPerPeople")
        @Expose
        private Double oneDeathPerPeople;
        @SerializedName("oneTestPerPeople")
        @Expose
        private Double oneTestPerPeople;
        @SerializedName("undefined")
        @Expose
        private Double undefined;
        @SerializedName("activePerOneMillion")
        @Expose
        private Double activePerOneMillion;
        @SerializedName("recoveredPerOneMillion")
        @Expose
        private Double recoveredPerOneMillion;
        @SerializedName("criticalPerOneMillion")
        @Expose
        private Double criticalPerOneMillion;

        public Long getUpdated() {
            return updated;
        }

        public void setUpdated(Long updated) {
            this.updated = updated;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getCases() {
            return cases;
        }

        public void setCases(Integer cases) {
            this.cases = cases;
        }

        public Integer getTodayCases() {
            return todayCases;
        }

        public void setTodayCases(Integer todayCases) {
            this.todayCases = todayCases;
        }

        public Integer getDeaths() {
            return deaths;
        }

        public void setDeaths(Integer deaths) {
            this.deaths = deaths;
        }

        public Integer getTodayDeaths() {
            return todayDeaths;
        }

        public void setTodayDeaths(Integer todayDeaths) {
            this.todayDeaths = todayDeaths;
        }

        public Integer getRecovered() {
            return recovered;
        }

        public void setRecovered(Integer recovered) {
            this.recovered = recovered;
        }

        public Integer getTodayRecovered() {
            return todayRecovered;
        }

        public void setTodayRecovered(Integer todayRecovered) {
            this.todayRecovered = todayRecovered;
        }

        public Integer getActive() {
            return active;
        }

        public void setActive(Integer active) {
            this.active = active;
        }

        public Integer getCritical() {
            return critical;
        }

        public void setCritical(Integer critical) {
            this.critical = critical;
        }

        public Double getCasesPerOneMillion() {
            return casesPerOneMillion;
        }

        public void setCasesPerOneMillion(Double casesPerOneMillion) {
            this.casesPerOneMillion = casesPerOneMillion;
        }

        public Double getDeathsPerOneMillion() {
            return deathsPerOneMillion;
        }

        public void setDeathsPerOneMillion(Double deathsPerOneMillion) {
            this.deathsPerOneMillion = deathsPerOneMillion;
        }

        public Integer getTests() {
            return tests;
        }

        public void setTests(Integer tests) {
            this.tests = tests;
        }

        public Double getTestsPerOneMillion() {
            return testsPerOneMillion;
        }

        public void setTestsPerOneMillion(Double testsPerOneMillion) {
            this.testsPerOneMillion = testsPerOneMillion;
        }

        public Integer getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

        public String getContinent() {
            return continent;
        }

        public void setContinent(String continent) {
            this.continent = continent;
        }

        public Double getOneCasePerPeople() {
            return oneCasePerPeople;
        }

        public void setOneCasePerPeople(Double oneCasePerPeople) {
            this.oneCasePerPeople = oneCasePerPeople;
        }

        public Double getOneDeathPerPeople() {
            return oneDeathPerPeople;
        }

        public void setOneDeathPerPeople(Double oneDeathPerPeople) {
            this.oneDeathPerPeople = oneDeathPerPeople;
        }

        public Double getOneTestPerPeople() {
            return oneTestPerPeople;
        }

        public void setOneTestPerPeople(Double oneTestPerPeople) {
            this.oneTestPerPeople = oneTestPerPeople;
        }

        public Double getUndefined() {
            return undefined;
        }

        public void setUndefined(Double undefined) {
            this.undefined = undefined;
        }

        public Double getActivePerOneMillion() {
            return activePerOneMillion;
        }

        public void setActivePerOneMillion(Double activePerOneMillion) {
            this.activePerOneMillion = activePerOneMillion;
        }

        public Double getRecoveredPerOneMillion() {
            return recoveredPerOneMillion;
        }

        public void setRecoveredPerOneMillion(Double recoveredPerOneMillion) {
            this.recoveredPerOneMillion = recoveredPerOneMillion;
        }

        public Double getCriticalPerOneMillion() {
            return criticalPerOneMillion;
        }

        public void setCriticalPerOneMillion(Double criticalPerOneMillion) {
            this.criticalPerOneMillion = criticalPerOneMillion;
        }



}


