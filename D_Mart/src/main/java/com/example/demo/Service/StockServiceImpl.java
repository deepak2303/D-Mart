package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.LocationNotFoundException;
import com.example.demo.Exceptions.StockNotFoundException;
import com.example.demo.Model.Location;
import com.example.demo.Model.Stock;
import com.example.demo.Repository.LocationRepository;
import com.example.demo.Repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Stock addStockItem(Stock stock) {
		// TODO Auto-generated method stub
		return stockRepository.save(stock);
	}

	@Override
	public Stock updateStockQuantity(Long stockId, int quantity) throws StockNotFoundException {
		// TODO Auto-generated method stub
		Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + stockId));
        
        stock.setQuantity(quantity);
        
        return stockRepository.save(stock);
	}

	@Override
	public void deleteStock(Long stockId) throws StockNotFoundException {
		// TODO Auto-generated method stub
		Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + stockId));
        
        stockRepository.delete(stock);
	}

	@Override
	public List<Stock> getAllStockItems() {
		// TODO Auto-generated method stub
		return stockRepository.findAll();
	}

	@Override
	public Stock assignStockToLocation(Long stockId, Long locationId) throws StockNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new StockNotFoundException("Stock item not found with ID: " + stockId));
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException("Stock location not found with ID: " + locationId));
        
        stock.setStockLocation(location);
        return stockRepository.save(stock);
	}

}
