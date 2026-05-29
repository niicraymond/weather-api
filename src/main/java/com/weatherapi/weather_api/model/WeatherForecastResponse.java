package com.weatherapi.weather_api.model;

public class WeatherForecastResponse {

    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Current {
        private double temperature_2m;
        private double wind_speed_10m;
        private int weather_code;

        public double getTemperature_2m() {
            return temperature_2m;
        }

        public void setTemperature_2m(double temperature_2m) {
            this.temperature_2m = temperature_2m;
        }

        public double getWind_speed_10m() {
            return wind_speed_10m;
        }

        public void setWind_speed_10m(double wind_speed_10m) {
            this.wind_speed_10m = wind_speed_10m;
        }

        public int getWeather_code() {
            return weather_code;
        }

        public void setWeather_code(int weather_code) {
            this.weather_code = weather_code;
        }
    }
}
