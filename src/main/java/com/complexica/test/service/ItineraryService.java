package com.complexica.test.service;

import com.complexica.test.model.ItineraryEntity;

public interface ItineraryService {
    ItineraryEntity save(ItineraryEntity itinerary);

    ItineraryEntity findItineraryByName(String itinerary);

    ItineraryEntity findById(Long id);
}
