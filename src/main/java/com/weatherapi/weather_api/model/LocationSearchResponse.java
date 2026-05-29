package com.weatherapi.weather_api.model;
import java.util.List;

public class LocationSearchResponse {
   private List<LocationResult> results;

   //getter
   public List<LocationResult> getResults() {
       return results;
   }
   //setter
   public void setResults(List<LocationResult> results) {
       this.results = results;
   }

    public static class LocationResult {
        private double latitude;
        private double longitude;

        //getter

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        //setter


        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }


}