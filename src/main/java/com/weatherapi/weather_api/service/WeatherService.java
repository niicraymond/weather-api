package com.weatherapi.weather_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weatherapi.weather_api.model.LocationSearchResponse;
import com.weatherapi.weather_api.model.WeatherForecastResponse;

@Service
public class WeatherService {
    public String getWeather(String location) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + location;
        LocationSearchResponse response = restTemplate.getForObject(url, LocationSearchResponse.class);
        double lat = response.getResults().get(0).getLatitude();
        double lon = response.getResults().get(0).getLongitude();


        String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&current=temperature_2m,wind_speed_10m,weather_code";

        WeatherForecastResponse weather =
                restTemplate.getForObject(weatherUrl, WeatherForecastResponse.class);

        double temp = weather.getCurrent().getTemperature_2m();
        double wind = weather.getCurrent().getWind_speed_10m();
        int code = weather.getCurrent().getWeather_code();

        String description;


        if (code == 0) {
            description = "Clear sky";
        } else if (code == 1) {
            description = "Mainly clear";
        } else if (code == 2) {
            description = "Partly cloudy";
        } else if (code == 3) {
            description = "Overcast";
        } else if (code == 45) {
            description = "Fog";
        } else if (code == 48) {
            description = "Rime fog";
        } else if (code == 51) {
            description = "Light drizzle";
        } else if (code == 53) {
            description = "Moderate drizzle";
        } else if (code == 55) {
            description = "Heavy drizzle";
        } else if (code == 61) {
            description = "Light rain";
        } else if (code == 63) {
            description = "Moderate rain";
        } else if (code == 65) {
            description = "Heavy rain";
        } else if (code == 71) {
            description = "Light snow";
        } else if (code == 73) {
            description = "Moderate snow";
        } else if (code == 75) {
            description = "Heavy snow";
        } else {
            description = "Unknown";
        }



        return "Weather in " + location + ": " + description + ", Temp: " + temp + ", Wind: " + wind;


    }
}
