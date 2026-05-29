package com.weatherapi.weather_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weatherapi.weather_api.model.LocationSearchResponse;

@Service
public class WeatherService {
    public String getWeather(String location) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + location;
        LocationSearchResponse response = restTemplate.getForObject(url, LocationSearchResponse.class);
        double lat = response.getResults().get(0).getLatitude();
        double lon = response.getResults().get(0).getLongitude();
        return "Lat: " + lat + ", Lon: " + lon;
    }
}
