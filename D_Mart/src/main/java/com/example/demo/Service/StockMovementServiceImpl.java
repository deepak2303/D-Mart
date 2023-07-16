package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.LocationNotFoundException;
import com.example.demo.Exceptions.StockNotFoundException;
import com.example.demo.Model.Location;
import com.example.demo.Model.Stock;
import com.example.demo.Model.StockMovement;
import com.example.demo.Repository.LocationRepository;
import com.example.demo.Repository.StockMovementRepository;
import com.example.demo.Repository.StockRepository;

@Service
public class StockMovementServiceImpl implements StockMovementService {
	
	@Autowired
	private StockMovementRepository stockMovementRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<StockMovement> getAllStockMovements() {
		// TODO Auto-generated method stub
		return stockMovementRepository.findAll();
	}

	@Override
	public StockMovement addStockMovement(StockMovement stockMovement) throws StockNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		Stock stock = stockRepository.findById(stockMovement.getStock().getId()).orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + stockMovement.getStock().getId()));
		Location location = locationRepository.findById(stockMovement.getLocation().getId()).orElseThrow(() -> new LocationNotFoundException("Location not found with id: " + stockMovement.getLocation().getId()));
	    Location destination = locationRepository.findById(stockMovement.getDestination().getId()).orElseThrow(() -> new LocationNotFoundException("Destination not found with id: " + stockMovement.getDestination().getId()));
	    stockMovement.setStock(stock);
        stockMovement.setLocation(location);
        stockMovement.setDestination(destination);
        
        return stockMovementRepository.save(stockMovement);
	}

}
