package com.toyStore.service;

import java.util.List;

import com.toyStore.model.Supplier;

public interface SupplierService {
	 Supplier addSupplier(Supplier supplier);
	    Supplier getSupplierById(Long id);
	    List<Supplier> getAllSuppliers();
	    void updateSupplier(Supplier supplier);
	    void deleteSupplier(Long id);
}
