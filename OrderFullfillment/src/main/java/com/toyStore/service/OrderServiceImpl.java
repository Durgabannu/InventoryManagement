package com.toyStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.toyStore.FeignClient.InventoryTrackingFeignClient;
import com.toyStore.FeignClient.ReportingFeignClient;
import com.toyStore.FeignClient.STockReplenishmentFeignClient;
import com.toyStore.model.InventoryItem;
import com.toyStore.model.Order;
import com.toyStore.model.Report;
import com.toyStore.model.Stock;
import com.toyStore.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	 @Autowired
	    private OrderRepository orderRepository;
	 
	 @Autowired
	    private InventoryTrackingFeignClient inventoryTrackingFeignClient;

	    @Autowired
	    private ReportingFeignClient reportingFeignClient;

	    @Autowired
	    private STockReplenishmentFeignClient stockReplenishmentFeignClient;

	    @Override
	    public Order placeOrder(Order order) {
	        return orderRepository.save(order);
	    }

	    @Override
	    public Order getOrderById(Long id) {
	        return orderRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    @Override
	    public void updateOrder(Order order) {
	        orderRepository.save(order);
	    }

	    @Override
	    public void deleteOrder(Long id) {
	        orderRepository.deleteById(id);
	    }
	    
	    //inventory
	    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
	        return inventoryTrackingFeignClient.getAllInventoryItems();
	    }
       //report
	    public ResponseEntity<List<Report>> getAllReports() {
	        return reportingFeignClient.getAllReports();
	    }
//stock
	    public ResponseEntity<?> getStockByItemId(Long itemId) {
	        return stockReplenishmentFeignClient.getStockByItemId(itemId);
	    }

	    public ResponseEntity<List<Stock>> getAllStocks() {
	        return stockReplenishmentFeignClient.getAllStocks();
	    }
}