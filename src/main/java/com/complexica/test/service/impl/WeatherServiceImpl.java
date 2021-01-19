package com.complexica.test.service.impl;

import com.complexica.test.vo.WeatherData;
import com.complexica.test.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplate restTemplate;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiURL;

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherData fetchWeatherData(String city) {
        return restTemplate.getForObject(String.format(apiURL, city, apiKey), WeatherData.class);
    }
}
