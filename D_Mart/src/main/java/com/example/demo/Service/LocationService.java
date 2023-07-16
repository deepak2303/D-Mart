package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Location;

public interface LocationService {
 
	public List<Location> getAllStockLocations();
	
	public Location addStockLocation(Location stockLocation);
	
	public void deleteStockLocation(Long locationId);
	
}