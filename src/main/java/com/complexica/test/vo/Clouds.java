package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Clouds {

    @JsonProperty("all")
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Clouds.class.getSimpleName() + "[", "]")
                .add("all=" + all)
                .toString();
    }
}
