package com.toyStore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.toyStore.model.Order;
import com.toyStore.model.Stock;
import com.toyStore.model.Supplier;

public interface SupplierService {
	 Supplier addSupplier(Supplier supplier);
	    Supplier getSupplierById(Long id);
	    List<Supplier> getAllSuppliers();
	    void updateSupplier(Supplier supplier);
	    void deleteSupplier(Long id);
		ResponseEntity<?> getOrderById(Long id);
		ResponseEntity<List<Order>> getAllOrders();
		ResponseEntity<?> getStockByItemId(Long itemId);
		ResponseEntity<List<Stock>> getAllStocks();
}
