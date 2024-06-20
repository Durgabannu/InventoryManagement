package com.toyStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.toyStore.feignClient.InventoryFeignClient;
import com.toyStore.feignClient.OrderFulfillmentFeignCleint;
import com.toyStore.feignClient.ReportingFeignClient;
import com.toyStore.model.InventoryItem;
import com.toyStore.model.Order;
import com.toyStore.model.Report;
import com.toyStore.model.Stock;
import com.toyStore.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    
    @Autowired
    private ReportingFeignClient reportingFeignClient;

    @Autowired
    private OrderFulfillmentFeignCleint orderFulfillmentFeignClient;

    @Autowired
    private InventoryFeignClient inventoryFeignClient;

    @Override
    public Stock replenishStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockByItemId(Long itemId) {
        return stockRepository.findByItemId(itemId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void updateStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
    
    //Report
    public ResponseEntity<List<Report>> getAllReports() {
        return reportingFeignClient.getAllReports();
    }
    //order
    public ResponseEntity<?> getOrderById(Long id) {
        return orderFulfillmentFeignClient.getOrderById(id);
    }

    public ResponseEntity<List<Order>> getAllOrders() {
        return orderFulfillmentFeignClient.getAllOrders();
    }
    //inventory
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        return inventoryFeignClient.getAllInventoryItems();
    }
}
