package com.example.demo.Service;

import java.util.List;

import com.example.demo.Exceptions.LocationNotFoundException;
import com.example.demo.Exceptions.StockNotFoundException;
import com.example.demo.Model.Stock;

public interface StockService {

	public Stock addStockItem(Stock stock);
	
	public Stock updateStockQuantity(Long stockId, int quantity) throws StockNotFoundException;
	
	public void deleteStock(Long stockId) throws StockNotFoundException;
	
	public List<Stock> getAllStockItems();
	
	public Stock assignStockToLocation(Long stockId, Long locationId) throws StockNotFoundException, LocationNotFoundException;
	
}