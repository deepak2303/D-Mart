package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Exceptions.LocationNotFoundException;
import com.example.demo.Exceptions.StockNotFoundException;
import com.example.demo.Model.StockMovement;
import com.example.demo.Service.StockMovementService;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementController {

	@Autowired
	private StockMovementService stockMovementService;
	
	@PostMapping
    public StockMovement addStockMovement(@RequestBody StockMovement stockMovement) throws StockNotFoundException, LocationNotFoundException {
        return stockMovementService.addStockMovement(stockMovement);
    }
	
	@GetMapping
    public List<StockMovement> getAllStockMovements() {
        return stockMovementService.getAllStockMovements();
    }
}
