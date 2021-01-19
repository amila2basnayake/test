package com.complexica.test.vo;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListItem {

    @JsonProperty("dt")
    private Date dt;

    @JsonProperty("pop")
    private int pop;

    @JsonProperty("visibility")
    private int visibility;

    @JsonProperty("dt_txt")
    private String dtTxt;

    @JsonProperty("weather")
    private List<WeatherItem> weather;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("rain")
    private Rain rain;

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public List<WeatherItem> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherItem> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListItem listItem = (ListItem) o;
        return dt.equals(listItem.dt) && dtTxt.equals(listItem.dtTxt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dt, dtTxt);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ListItem.class.getSimpleName() + "[", "]")
                .add("dt=" + dt)
                .add("pop=" + pop)
                .add("visibility=" + visibility)
                .add("dtTxt='" + dtTxt + "'")
                .add("weather=" + weather)
                .add("main=" + main)
                .add("clouds=" + clouds)
                .add("sys=" + sys)
                .add("wind=" + wind)
                .add("rain=" + rain)
                .toString();
    }
}
