package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.model.Location;

import java.util.List;

@Component
public class LocationManagement {


    @Autowired
    private LocationRepository locationRepository;

    public List<Location> geAllLocations() {
        return locationRepository.getAllLocations();
    }
}
