package com.complexica.test.service;

import com.complexica.test.model.TravelEntity;
import com.complexica.test.vo.TravelData;
import com.complexica.test.vo.WeatherData;

import java.util.List;

public interface TravelService {
    TravelEntity save(TravelData travelData, WeatherData weatherData);

    List<TravelEntity> fetchAll();
}
