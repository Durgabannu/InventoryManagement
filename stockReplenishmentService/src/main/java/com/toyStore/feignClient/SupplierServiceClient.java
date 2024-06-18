package com.toyStore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.toyStore.model.Supplier;
@FeignClient(name = "supplierManagementService")
public interface SupplierServiceClient {
	@GetMapping("/suppliers/{id}")
    ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long id);

}
