package spicinemas.api.model;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Screen {

    private Long id;
    private String name;
    private Long locationId;
    private int capacity;

    public Screen(Long id, String name, Long locationId, int capacity) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
        this.capacity = capacity;
    }

    public Screen(String name, Long locationId, int capacity) {
        this.name = name;
        this.locationId = locationId;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getLocationId() {
        return locationId;
    }

    public int getCapacity() {
        return capacity;
    }
}
