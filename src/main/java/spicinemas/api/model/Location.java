package spicinemas.api.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Location {

    private Long id;
    private String city;

    public Location(Long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Location(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
