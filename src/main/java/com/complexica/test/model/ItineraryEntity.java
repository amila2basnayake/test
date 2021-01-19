package com.complexica.test.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "itinerary")
public class ItineraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "travel_itinerary",
            joinColumns = @JoinColumn(name = "travel_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "itinerary_id", referencedColumnName = "id")
    )
    private List<TravelEntity> travelEntityList;

    public ItineraryEntity() {
    }

    public ItineraryEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TravelEntity> getTravelEntityList() {
        return travelEntityList;
    }

    public void setTravelEntityList(List<TravelEntity> travelEntityList) {
        this.travelEntityList = travelEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItineraryEntity that = (ItineraryEntity) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItineraryEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("travelEntityList=" + travelEntityList)
                .toString();
    }
}
