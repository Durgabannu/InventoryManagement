package com.toyStore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.toyStore.model.InventoryItem;
import com.toyStore.model.Order;
import com.toyStore.model.Report;
import com.toyStore.model.Stock;

public interface StockService {
	 Stock replenishStock(Stock stock);
	    Stock getStockByItemId(Long itemId);
	    List<Stock> getAllStocks();
	    void updateStock(Stock stock);
	    void deleteStock(Long id);
		ResponseEntity<List<Report>> getAllReports();
		ResponseEntity<?> getOrderById(Long id);
		ResponseEntity<List<Order>> getAllOrders();
		ResponseEntity<List<InventoryItem>> getAllInventoryItems();
}
