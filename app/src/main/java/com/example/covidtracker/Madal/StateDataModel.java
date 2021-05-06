package com.example.covidtracker.Madal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StateDataModel {

    private String country;
    private String county;
    private String updatedAt;
    private Stats stats;

    public Stats getStats() {
        return stats;
    }

    private Object coordinates;
    private String province;
//    private  String stats;
//
//    public String getStats() {
//        return stats;
//    }
    @SerializedName("CountDetails")
    private MoreDetails moreDetails;

    public StateDataModel(String country, String county, String updatedAt, Object coordinates, String province, MoreDetails moreDetails) {
        this.country = country;
        this.county = county;
        this.updatedAt = updatedAt;
        this.coordinates = coordinates;
        this.province = province;
        this.moreDetails = moreDetails;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public Object getStats() {
//        return stats;
//    }
//
//    public void setStats(Object stats) {
//        this.stats = stats;
//    }

    public Object getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public static class Stats {
        private int confirmed;
        private int deaths;
        private int recovered;

        public int getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(int confirmed) {
            this.confirmed = confirmed;
        }

        public int getDeaths() {
            return deaths;
        }

        public void setDeaths(int deaths) {
            this.deaths = deaths;
        }

        public int getRecovered() {
            return recovered;
        }

        public void setRecovered(int recovered) {
            this.recovered = recovered;
        }
    }

    public static class Coordinates {
        private String latitude;
        private String longitude;

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }
}
