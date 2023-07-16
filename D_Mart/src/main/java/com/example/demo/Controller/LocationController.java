package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Location;
import com.example.demo.Service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@GetMapping
    public List<Location> getAllStockLocations() {
        return locationService.getAllStockLocations();
    }

    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationService.addStockLocation(location);
    }

    @DeleteMapping("/{locationId}")
    public void deleteStockLocation(@PathVariable Long locationId) {
        locationService.deleteStockLocation(locationId);
    }
}
