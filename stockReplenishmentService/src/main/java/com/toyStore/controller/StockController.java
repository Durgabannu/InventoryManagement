package com.toyStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyStore.model.Stock;
import com.toyStore.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {
	 @Autowired
	    private StockService stockService;

	    @PostMapping("/replenish")
	    public ResponseEntity<?> replenishStock(@RequestBody Stock stock) {
	        try {
	            Stock replenishedStock = stockService.replenishStock(stock);
	            return new ResponseEntity<>(replenishedStock, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Stock could not be replenished", HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/{itemId}")
	    public ResponseEntity<?> getStockByItemId(@PathVariable("itemId") Long itemId) {
	        try {
	            Stock stock = stockService.getStockByItemId(itemId);
	            if (stock != null) {
	                return new ResponseEntity<>(stock, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>("Stock not found", HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred while fetching the stock", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Stock>> getAllStocks() {
	        List<Stock> stocks = stockService.getAllStocks();
	        return ResponseEntity.ok(stocks);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Void> updateStock(@PathVariable("id") Long id, @RequestBody Stock stock) {
	        stock.setId(id);
	        stockService.updateStock(stock);
	        return ResponseEntity.ok().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStock(@PathVariable("id") Long id) {
	        stockService.deleteStock(id);
	        return ResponseEntity.ok().build();
	    }

}
