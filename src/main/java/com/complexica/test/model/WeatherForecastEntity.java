package com.complexica.test.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "weather_forecast")
public class WeatherForecastEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double temperature;

    @ManyToOne
    @JoinColumn(name = "city")
    private CityEntity city;

    private Integer clouds;

    @Column(name = "forecast_date_time")
    private Date forecastDate;

    @Column(name = "created_date")
    private Date createdDate;

    public WeatherForecastEntity() {
    }

    public WeatherForecastEntity(Long id, Double temperature, CityEntity city, Integer clouds, Date forecastDate) {
        this.id = id;
        this.temperature = temperature;
        this.city = city;
        this.clouds = clouds;
        this.forecastDate = forecastDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Date getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(Date forecastDate) {
        this.forecastDate = forecastDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeatherForecastEntity that = (WeatherForecastEntity) o;
        return id.equals(that.id) && city.equals(that.city) && forecastDate.equals(that.forecastDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, forecastDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeatherForecastEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("temperature=" + temperature)
                .add("city=" + city)
                .add("clouds=" + clouds)
                .add("forecastDate=" + forecastDate)
                .add("createdDate=" + createdDate)
                .toString();
    }
}
