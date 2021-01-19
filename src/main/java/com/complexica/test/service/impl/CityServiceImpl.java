package com.complexica.test.service.impl;

import com.complexica.test.model.CityEntity;
import com.complexica.test.repository.CityRepository;
import com.complexica.test.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityEntity save(CityEntity cityEntity) {
        return cityRepository.save(cityEntity);
    }

    @Override
    public CityEntity findCityByNameAndCountryCode(String name, String country) {
        return cityRepository.findByNameAndCountryCode(name, country);
    }
}
