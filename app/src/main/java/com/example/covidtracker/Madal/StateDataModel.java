package com.example.covidtracker.Madal;

public class StateDataModel {

    private String country;
    private String county;
    private String updatedAt;
    private String stats;
    private Double coordinates;
    private String province;

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

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public Double getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double coordinates) {
        this.coordinates = coordinates;
    }

    public Object getProvince() {
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