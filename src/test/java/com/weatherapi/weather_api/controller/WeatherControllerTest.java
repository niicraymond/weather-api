package com.weatherapi.weather_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnLocation_whenValidInput() throws Exception {

        // given
        String location = "London";

        // when
        var request = get("/weather")
                .param("location", location);

        // then
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(location));
    }

}