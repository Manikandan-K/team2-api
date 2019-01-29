package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.management.LocationManagement;
import spicinemas.api.model.Location;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationManagement locationManagement;

    @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getLocations( ) {
        return locationManagement.geAllLocations();
    }
}
