package com.complexica.test.repository;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherForecastEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecastEntity, Long> {

    WeatherForecastEntity findByCityAndAndForecastDate(CityEntity city, Date forecastDate);
}
