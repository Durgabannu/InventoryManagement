package com.toyStore.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.toyStore.model.InventoryItem;
import com.toyStore.model.Order;
import com.toyStore.model.Report;
import com.toyStore.model.Stock;
public interface OrderService {

	Order placeOrder(Order order);

	Order getOrderById(Long id);

	List<Order> getAllOrders();

	void updateOrder(Order order);

	void deleteOrder(Long id);

	ResponseEntity<List<InventoryItem>> getAllInventoryItems();

	ResponseEntity<List<Report>> getAllReports();

	ResponseEntity<?> getStockByItemId(Long itemId);

	ResponseEntity<List<Stock>> getAllStocks();
}
