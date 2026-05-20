package com.weatherapi.weather_api.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public String getWeather(String location) {
        return "The weather is good in " + location;
    }
}
