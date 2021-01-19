package com.complexica.test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Sys {

    @JsonProperty("pod")
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Sys.class.getSimpleName() + "[", "]")
                .add("pod='" + pod + "'")
                .toString();
    }
}
