package com.complexica.test.service.impl;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.TravelEntity;
import com.complexica.test.model.WeatherForecastEntity;
import com.complexica.test.repository.TravelRepository;
import com.complexica.test.service.CityService;
import com.complexica.test.service.ItineraryService;
import com.complexica.test.service.TravelService;
import com.complexica.test.service.WeatherForecastService;
import com.complexica.test.vo.ListItem;
import com.complexica.test.vo.TravelData;
import com.complexica.test.vo.WeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    private final Logger logger = LoggerFactory.getLogger(TravelService.class);

    private final TravelRepository travelRepository;
    private final CityService cityService;
    private final WeatherForecastService weatherForecastService;
    private final SimpleDateFormat dateFormat;
    private final DateTimeFormatter dateTimeFormatter;
    private final ItineraryService itineraryService;

    public TravelServiceImpl(TravelRepository travelRepository,
                             CityService cityService,
                             WeatherForecastService weatherForecastService,
                             ItineraryService itineraryService) {
        this.travelRepository = travelRepository;
        this.cityService = cityService;
        this.weatherForecastService = weatherForecastService;
        this.itineraryService = itineraryService;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public TravelEntity save(TravelData travelData, WeatherData weatherData) {
        CityEntity cityEntity = cityService.findCityByNameAndCountryCode(weatherData.getCity().getName(), weatherData.getCity().getCountry());

        if (cityEntity == null) {
            cityEntity = cityService.save(new CityEntity(weatherData.getCity().getName(), weatherData.getCity().getCountry()));
        } else {
            logger.info("City found for country code - {} and name - {}", weatherData.getCity().getCountry(), weatherData.getCity().getName());
        }
        Calendar calendar = Calendar.getInstance();

        TravelEntity travel = new TravelEntity(travelData.getDate(), cityEntity);

        travel.setItineraryEntityList(Collections.singletonList(itineraryService.findById(Long.parseLong(travelData.getItinerary()))));

        travel = travelRepository.save(travel);
        for (ListItem listItem : weatherData.getList()) {
            WeatherForecastEntity weatherForecastEntity = new WeatherForecastEntity();
            weatherForecastEntity.setCity(cityEntity);
            weatherForecastEntity.setClouds(listItem.getClouds().getAll());
            weatherForecastEntity.setTemperature(listItem.getMain().getTemp());
            weatherForecastEntity.setCreatedDate(new Date());
            Date date;
            try {
                date = this.dateFormat.parse(listItem.getDtTxt());
            } catch (ParseException e) {
                date = listItem.getDt();
            }
            weatherForecastEntity.setForecastDate(date);

            // add all records between 12pm and 6pm
            LocalDateTime localDateTime = LocalDateTime.parse(listItem.getDtTxt(), dateTimeFormatter);
            WeatherForecastEntity tmp = weatherForecastService.findWeatherForecastByCityAndForecastDate(cityEntity, date);
            if (localDateTime.getHour() >= 12 && localDateTime.getHour() <= 18) {
                if (tmp == null) {
                    weatherForecastEntity = weatherForecastService.save(weatherForecastEntity);
                } else {
                    // delete forecast data that's older than 1hr and recreate them
                    calendar.add(Calendar.HOUR_OF_DAY, -1);
                    if (tmp.getCreatedDate().before(calendar.getTime())) {
                        weatherForecastService.delete(tmp);
                        weatherForecastEntity = weatherForecastService.save(weatherForecastEntity);
                    }
                }
            }
        }
        return travel;
    }

    @Override
    public List<TravelEntity> fetchAll() {
        return travelRepository.findAll();
    }
}
