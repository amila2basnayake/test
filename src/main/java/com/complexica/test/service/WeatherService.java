package com.complexica.test.service;


import com.complexica.test.vo.WeatherData;

public interface WeatherService {
    WeatherData fetchWeatherData(String city);
}
