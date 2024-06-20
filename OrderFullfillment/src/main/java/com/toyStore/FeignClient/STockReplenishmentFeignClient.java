package com.toyStore.FeignClient;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.toyStore.model.Stock;
@FeignClient(name = "stock-replenishment-service", url = "http://localhost:8072")

public interface STockReplenishmentFeignClient {

		  @GetMapping("/stocks/{itemId}")
		    public ResponseEntity<?> getStockByItemId(@PathVariable("itemId") Long itemId);
		    @GetMapping("/stocks/all")
		    public ResponseEntity<List<Stock>> getAllStocks();
	}
