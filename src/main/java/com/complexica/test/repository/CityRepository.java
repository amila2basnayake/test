package com.complexica.test.repository;

import com.complexica.test.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    CityEntity findByNameAndCountryCode(String name, String countryCode);
}
