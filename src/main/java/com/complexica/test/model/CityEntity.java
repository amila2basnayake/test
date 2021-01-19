package com.complexica.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "city")
public class CityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @OneToMany(mappedBy = "city")
    private List<TravelEntity> travelEntities;

    @OneToMany(mappedBy = "city")
    private List<WeatherForecastEntity> weatherForecastEntities;

    public CityEntity() {
    }

    public CityEntity(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<TravelEntity> getTravelEntities() {
        return travelEntities;
    }

    public void setTravelEntities(List<TravelEntity> travelEntities) {
        this.travelEntities = travelEntities;
    }

    public List<WeatherForecastEntity> getWeatherForecastEntities() {
        return weatherForecastEntities;
    }

    public void setWeatherForecastEntities(List<WeatherForecastEntity> weatherForecastEntities) {
        this.weatherForecastEntities = weatherForecastEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CityEntity that = (CityEntity) o;
        return id.equals(that.id) && name.equals(that.name) && countryCode.equals(that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CityEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("countryCode='" + countryCode + "'")
                .toString();
    }
}
