package com.toyStore.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.toyStore.model.Stock;

@FeignClient(name = "stockReplenishmentService")

public interface StockServiceClient {
	 @GetMapping("/stocks/all")
	    ResponseEntity<List<Stock>> getAllStocks();
}
