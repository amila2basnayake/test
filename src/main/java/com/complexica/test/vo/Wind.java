package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Wind {

    @JsonProperty("deg")
    private int deg;

    @JsonProperty("speed")
    private double speed;

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Wind.class.getSimpleName() + "[", "]")
                .add("deg=" + deg)
                .add("speed=" + speed)
                .toString();
    }
}
