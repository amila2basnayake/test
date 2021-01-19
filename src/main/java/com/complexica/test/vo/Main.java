package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Main {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("temp_min")
    private double tempMin;

    @JsonProperty("grnd_level")
    private int grndLevel;

    @JsonProperty("temp_kf")
    private double tempKf;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("sea_level")
    private int seaLevel;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("temp_max")
    private double tempMax;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public int getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }

    public double getTempKf() {
        return tempKf;
    }

    public void setTempKf(double tempKf) {
        this.tempKf = tempKf;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Main.class.getSimpleName() + "[", "]")
                .add("temp=" + temp)
                .add("tempMin=" + tempMin)
                .add("grndLevel=" + grndLevel)
                .add("tempKf=" + tempKf)
                .add("humidity=" + humidity)
                .add("pressure=" + pressure)
                .add("seaLevel=" + seaLevel)
                .add("feelsLike=" + feelsLike)
                .add("tempMax=" + tempMax)
                .toString();
    }
}
