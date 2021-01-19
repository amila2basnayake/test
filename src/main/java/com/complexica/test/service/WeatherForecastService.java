package com.complexica.test.service;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherForecastEntity;

import java.util.Date;

public interface WeatherForecastService {
    WeatherForecastEntity save(WeatherForecastEntity weatherForecastEntity);

    WeatherForecastEntity findWeatherForecastByCityAndForecastDate(CityEntity city, Date forecastDate);

    void delete(WeatherForecastEntity weatherForecast);
}
