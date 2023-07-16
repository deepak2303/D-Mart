package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.LocationNotFoundException;
import com.example.demo.Exceptions.StockNotFoundException;
import com.example.demo.Model.Stock;
import com.example.demo.Service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;

    @PostMapping
    public Stock addStockItem(@RequestBody Stock stock) {
        return stockService.addStockItem(stock);
    }

    @PutMapping("/{stockId}")
    public Stock updateStockItemQuantity(@PathVariable Long stockId, @RequestParam int quantity) throws StockNotFoundException {
        return stockService.updateStockQuantity(stockId, quantity);
    }

    @DeleteMapping("/{stockId}")
    public void deleteStockItem(@PathVariable Long stockItemId) throws StockNotFoundException {
        stockService.deleteStock(stockItemId);
    }
    
    @GetMapping
    public List<Stock> getAllStockItems() {
        return stockService.getAllStockItems();
    }
    
    @PutMapping("/{stockId}/assign-location/{locationId}")
    public Stock assignStockToLocation(@PathVariable Long stockId, @PathVariable Long locationId) throws StockNotFoundException, LocationNotFoundException {
        return stockService.assignStockToLocation(stockId, locationId);
    }
}
