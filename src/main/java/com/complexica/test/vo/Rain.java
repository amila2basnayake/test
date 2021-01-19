package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Rain {

    @JsonProperty("3h")
    private double jsonMember3h;

    public double getJsonMember3h() {
        return jsonMember3h;
    }

    public void setJsonMember3h(double jsonMember3h) {
        this.jsonMember3h = jsonMember3h;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rain.class.getSimpleName() + "[", "]")
                .add("jsonMember3h=" + jsonMember3h)
                .toString();
    }
}
