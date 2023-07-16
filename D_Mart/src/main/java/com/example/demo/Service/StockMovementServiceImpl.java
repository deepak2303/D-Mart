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
		Location sourceLocation = locationRepository.findById(stockMovement.getSourceLocation().getId()).orElseThrow(() -> new LocationNotFoundException("Source location not found with id: " + stockMovement.getSourceLocation().getId()));
	    Location destinationLocation = locationRepository.findById(stockMovement.getDestinationLocation().getId()).orElseThrow(() -> new LocationNotFoundException("Destination location not found with id: " + stockMovement.getDestinationLocation().getId()));
	    stockMovement.setStock(stock);
        stockMovement.setSourceLocation(sourceLocation);
        stockMovement.setDestinationLocation(destinationLocation);
        
        return stockMovementRepository.save(stockMovement);
	}

}
