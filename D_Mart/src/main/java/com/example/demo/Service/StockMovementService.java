package com.example.demo.Service;

import java.util.List;

import com.example.demo.Exceptions.LocationNotFoundException;
import com.example.demo.Exceptions.StockNotFoundException;
import com.example.demo.Model.StockMovement;

public interface StockMovementService {

	public List<StockMovement> getAllStockMovements();
	
	public StockMovement addStockMovement(StockMovement stockMovement) throws StockNotFoundException, LocationNotFoundException;
	
}
