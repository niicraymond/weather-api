package com.weatherapi.weather_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.BDDMockito.given;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.weatherapi.weather_api.service.WeatherService;



@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @MockBean
    private WeatherService weatherService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnLocationWhenValidInput() throws Exception {

        // given
        String location = "London";
        String expected = "The weather is good in London";

        given(weatherService.getWeather(location))
                .willReturn(expected);


        // when
        var request = get("/weather")
                .param("location", location);

        // then
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test

    void shouldReturnBadRequestWhenLocationIsMissing() throws Exception{

        // given
        String location = "";

        // when
        var request = get("/weather")
                .param("location", location);

        // then
        mockMvc.perform(request)
                .andExpect(status().isBadRequest());


    }

}