package com.complexica.test.controller;

import com.complexica.test.model.ItineraryEntity;
import com.complexica.test.service.ItineraryService;
import com.complexica.test.vo.ItineraryData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/itinerary")
    public String index(Model model) {
        model.addAttribute("itineraryData", new ItineraryData());
        return "itinerary";
    }

    @PostMapping("/itinerary")
    public String createItinerary(@ModelAttribute ItineraryData itineraryData, BindingResult result, Model model) {
        if (itineraryData.getSearch()) {
            return "redirect:/travel-data?search=true&itinerary=" + itineraryData.getName();
        } else {
            ItineraryEntity itineraryEntity = itineraryService.save(new ItineraryEntity(itineraryData.getName()));
            return "redirect:/travel-data?itinerary=" + itineraryEntity.getId();
        }
    }

}
