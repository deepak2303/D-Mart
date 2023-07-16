package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Location;
import com.example.demo.Repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<Location> getAllStockLocations() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	@Override
	public Location addStockLocation(Location stockLocation) {
		// TODO Auto-generated method stub
		return locationRepository.save(stockLocation);
	}

	@Override
	public void deleteStockLocation(Long locationId) {
		// TODO Auto-generated method stub
		locationRepository.deleteById(locationId);
	}

}
