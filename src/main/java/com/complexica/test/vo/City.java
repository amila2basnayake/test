package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class City {

    @JsonProperty("country")
    private String country;

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("sunrise")
    private int sunrise;

    @JsonProperty("timezone")
    private int timezone;

    @JsonProperty("sunset")
    private int sunset;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;

    @JsonProperty("population")
    private int population;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return id == city.id && country.equals(city.country) && coord.equals(city.coord) && name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, coord, name, id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", City.class.getSimpleName() + "[", "]")
                .add("country='" + country + "'")
                .add("coord=" + coord)
                .add("sunrise=" + sunrise)
                .add("timezone=" + timezone)
                .add("sunset=" + sunset)
                .add("name='" + name + "'")
                .add("id=" + id)
                .add("population=" + population)
                .toString();
    }
}
