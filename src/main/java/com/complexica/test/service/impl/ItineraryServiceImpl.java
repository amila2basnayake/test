package com.complexica.test.service.impl;

import com.complexica.test.model.ItineraryEntity;
import com.complexica.test.repository.ItineraryRepository;
import com.complexica.test.service.ItineraryService;
import org.springframework.stereotype.Service;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public ItineraryServiceImpl(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    @Override
    public ItineraryEntity save(ItineraryEntity itinerary) {
        return itineraryRepository.save(itinerary);
    }

    @Override
    public ItineraryEntity findItineraryByName(String itinerary) {
        return itineraryRepository.findByName(itinerary);
    }

    @Override
    public ItineraryEntity findById(Long id) {
        return itineraryRepository.findById(id).orElse(null);
    }
}
