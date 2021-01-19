package com.complexica.test.service;


import com.complexica.test.model.CityEntity;

public interface CityService {
    CityEntity save(CityEntity cityEntity);

    CityEntity findCityByNameAndCountryCode(String name, String country);
}
