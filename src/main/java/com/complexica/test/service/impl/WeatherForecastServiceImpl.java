package com.complexica.test.service.impl;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherForecastEntity;
import com.complexica.test.repository.WeatherForecastRepository;
import com.complexica.test.service.WeatherForecastService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

    private final WeatherForecastRepository weatherForecastRepository;

    public WeatherForecastServiceImpl(WeatherForecastRepository weatherForecastRepository) {
        this.weatherForecastRepository = weatherForecastRepository;
    }

    @Override
    public WeatherForecastEntity save(WeatherForecastEntity weatherForecastEntity) {
        return weatherForecastRepository.save(weatherForecastEntity);
    }

    @Override
    public WeatherForecastEntity findWeatherForecastByCityAndForecastDate(CityEntity city, Date forecastDate) {
        return weatherForecastRepository.findByCityAndAndForecastDate(city, forecastDate);
    }

    @Override
    public void delete(WeatherForecastEntity weatherForecast) {
        weatherForecastRepository.delete(weatherForecast);
    }
}
