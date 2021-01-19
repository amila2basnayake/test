package com.complexica.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "travel")
public class TravelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "travel_date")
    private Date travelDate;

    @ManyToOne
    @JoinColumn(name = "city")
    private CityEntity city;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "travel_itinerary",
            joinColumns = @JoinColumn(name = "itinerary_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "travel_id", referencedColumnName = "id")
    )
    private List<ItineraryEntity> itineraryEntityList;

    public TravelEntity() {
    }

    public TravelEntity(Date travelDate, CityEntity city) {
        this.travelDate = travelDate;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public List<ItineraryEntity> getItineraryEntityList() {
        return itineraryEntityList;
    }

    public void setItineraryEntityList(List<ItineraryEntity> itineraryEntityList) {
        this.itineraryEntityList = itineraryEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TravelEntity that = (TravelEntity) o;
        return id.equals(that.id) && travelDate.equals(that.travelDate) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, travelDate, city);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TravelEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("travelDate=" + travelDate)
                .add("city=" + city)
                .add("itineraryEntityList=" + itineraryEntityList)
                .toString();
    }
}
