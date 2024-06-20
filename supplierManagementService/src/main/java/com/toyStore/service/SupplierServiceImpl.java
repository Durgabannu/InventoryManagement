package com.toyStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.toyStore.feignClient.OrderfulfillmentFeignCLient;
import com.toyStore.feignClient.StockServiceClient;
import com.toyStore.model.Order;
import com.toyStore.model.Stock;
import com.toyStore.model.Supplier;
import com.toyStore.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private OrderfulfillmentFeignCLient orderFulfillmentFeignClient;

    @Autowired
    private StockServiceClient stockServiceClient;
    
    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
    
    
    
    public ResponseEntity<?> getOrderById(Long id) {
        return orderFulfillmentFeignClient.getOrderById(id);
    }

    public ResponseEntity<List<Order>> getAllOrders() {
        return orderFulfillmentFeignClient.getAllOrders();
    }

    public ResponseEntity<?> getStockByItemId(Long itemId) {
        return stockServiceClient.getStockByItemId(itemId);
    }

    public ResponseEntity<List<Stock>> getAllStocks() {
        return stockServiceClient.getAllStocks();
    }
    

}
