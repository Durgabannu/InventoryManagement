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

import com.toyStore.model.InventoryItem;
import com.toyStore.model.Order;
import com.toyStore.model.Stock;
import com.toyStore.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
    private InventoryService inventoryService;
	
	 @PostMapping("/add")
	    public ResponseEntity<InventoryItem> createInventoryItem(@RequestBody InventoryItem newItem) {
	        InventoryItem createdItem = inventoryService.createInventoryItem(newItem);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
	    }
	 
	 @GetMapping("/{itemId}")
	    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable Long itemId) {
	        InventoryItem item = inventoryService.getInventoryItem(itemId);
	        if (item != null) {
	            return ResponseEntity.ok(item);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 @GetMapping("/all")
	    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
	        List<InventoryItem> inventoryItems = inventoryService.getAllInventoryItems();
	        return ResponseEntity.ok(inventoryItems);
	    }

	 @PutMapping("/{itemId}")
	    public ResponseEntity<InventoryItem> updateInventoryItem(
	            @PathVariable Long itemId, @RequestBody InventoryItem updatedItem) {
	        InventoryItem item = inventoryService.updateInventoryItem(itemId, updatedItem);
	        if (item != null) {
	            return ResponseEntity.ok(item);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	 }
	 @DeleteMapping("/{itemId}")
	    public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long itemId) {
	        boolean deleted = inventoryService.deleteInventoryItem(itemId);
	        if (deleted) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 //order Fulfillment 
	 @GetMapping("/orders/{id}")
	    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
	        return inventoryService.getOrderById(id);
	    }

	    @GetMapping("/orders/all")
	    public ResponseEntity<List<Order>> getAllOrders() {
	        return inventoryService.getAllOrders();
	    }
	    
	    //Stock

	    @GetMapping("/stocks/{itemId}")
	    public ResponseEntity<?> getStockByItemId(@PathVariable("itemId") Long itemId) {
	        return inventoryService.getStockByItemId(itemId);
	    }

	    @GetMapping("/stocks/all")
	    public ResponseEntity<List<Stock>> getAllStocks() {
	        return inventoryService.getAllStocks();
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
