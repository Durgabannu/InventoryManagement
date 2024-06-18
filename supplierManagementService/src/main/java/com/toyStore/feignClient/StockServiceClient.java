package com.toyStore.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.toyStore.model.Stock;

@FeignClient(name = "stockReplenishmentService")

public interface StockServiceClient {
	@GetMapping("/stocks/{itemId}")
    ResponseEntity<Stock> getStockByItemId(@PathVariable("itemId") Long itemId);
}
