package com.complexica.test.vo;

import java.util.List;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {

    @JsonProperty("city")
    private City city;

    @JsonProperty("cnt")
    private int cnt;

    @JsonProperty("cod")
    private String cod;

    @JsonProperty("message")
    private int message;

    @JsonProperty("list")
    private List<ListItem> list;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public List<ListItem> getList() {
        return list;
    }

    public void setList(List<ListItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeatherData.class.getSimpleName() + "[", "]")
                .add("city=" + city)
                .add("cnt=" + cnt)
                .add("cod='" + cod + "'")
                .add("message=" + message)
                .add("list=" + list)
                .toString();
    }
}
