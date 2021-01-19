package com.complexica.test.controller;

import com.complexica.test.model.ItineraryEntity;
import com.complexica.test.service.ItineraryService;
import com.complexica.test.service.TravelService;
import com.complexica.test.vo.TravelData;
import com.complexica.test.vo.WeatherData;
import com.complexica.test.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TravelDataController {
    private final Logger logger = LoggerFactory.getLogger(TravelDataController.class);
    private final WeatherService weatherService;
    private final TravelService travelService;
    private final ItineraryService itineraryService;

    public TravelDataController(WeatherService weatherService,
                                TravelService travelService,
                                ItineraryService itineraryService) {
        this.weatherService = weatherService;
        this.travelService = travelService;
        this.itineraryService = itineraryService;
    }

    @GetMapping("/travel-data")
    public String travelerData(Model model, @RequestParam(required = false) String itinerary, @RequestParam(required = false) boolean search) {
        ItineraryEntity itineraryEntity;
        if (search) {
            itineraryEntity = itineraryService.findItineraryByName(itinerary);
            model.addAttribute("travelData", new TravelData());
        } else {
            itineraryEntity = itineraryService.findById(Long.parseLong(itinerary));
            model.addAttribute("travelData", new TravelData(itinerary));
        }
        if (itineraryEntity != null) {
            model.addAttribute("travelDataList", itineraryEntity.getTravelEntityList());
        } else {
            model.addAttribute("travelDataList", new ArrayList<>());
        }
        return "travel-data";
    }

    @PostMapping("/travel-data")
    public String addTravelData(@ModelAttribute TravelData travelData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "travel-data";
        }
        model.addAttribute("travelData", new TravelData());

        WeatherData weatherData = weatherService.fetchWeatherData(travelData.getCity());
        travelService.save(travelData, weatherData);

        if (travelData.getItinerary() != null) {
            return "redirect:/travel-data?itinerary=" + travelData.getItinerary();
        } else {
            return "redirect:/travel-data";
        }
    }

}
