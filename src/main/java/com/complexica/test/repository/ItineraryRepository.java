package com.complexica.test.repository;

import com.complexica.test.model.ItineraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {

    ItineraryEntity findByName(String name);
}
