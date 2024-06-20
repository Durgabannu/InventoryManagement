package com.toyStore.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.toyStore.model.InventoryItem;

@FeignClient(name = "inventory-service", url = "http://localhost:8070")

public interface InventoryTrackingFeignClient {
	@GetMapping("/inventory/all")
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() ;
   
}
