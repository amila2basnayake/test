package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class WeatherItem {

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("description")
    private String description;

    @JsonProperty("main")
    private String main;

    @JsonProperty("id")
    private int id;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeatherItem.class.getSimpleName() + "[", "]")
                .add("icon='" + icon + "'")
                .add("description='" + description + "'")
                .add("main='" + main + "'")
                .add("id=" + id)
                .toString();
    }
}
