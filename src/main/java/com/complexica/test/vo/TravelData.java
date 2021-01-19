package com.complexica.test.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

public class TravelData {
    private String city;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String itinerary;

    public TravelData() {
    }

    public TravelData(String itinerary) {
        this.itinerary = itinerary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TravelData that = (TravelData) o;
        return city.equals(that.city) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TravelData.class.getSimpleName() + "[", "]")
                .add("city='" + city + "'")
                .add("date=" + date)
                .add("itinerary='" + itinerary + "'")
                .toString();
    }

}
