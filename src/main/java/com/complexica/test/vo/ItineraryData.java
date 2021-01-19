package com.complexica.test.vo;

import java.util.Objects;
import java.util.StringJoiner;

public class ItineraryData {
    private String name;
    private Boolean search = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItineraryData that = (ItineraryData) o;
        return name.equals(that.name) && search.equals(that.search);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, search);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItineraryData.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("search=" + search)
                .toString();
    }
}
