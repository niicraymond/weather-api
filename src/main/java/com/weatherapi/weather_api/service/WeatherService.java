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

        return "Lat: " + lat + ", Lon: " + lon + ", Temp: " + temp + ", Wind: " + wind;

    }
}
