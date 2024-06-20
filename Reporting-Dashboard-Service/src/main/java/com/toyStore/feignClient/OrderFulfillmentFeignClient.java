package com.toyStore.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.toyStore.model.Order;
@FeignClient(name = "order-fulfillment-service", url = "http://localhost:8071")

public interface OrderFulfillmentFeignClient {
	 @GetMapping("/orders/{id}")
	    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) ;
	       
	    @GetMapping("/orders/all")
	    public ResponseEntity<List<Order>> getAllOrders() ;
	    }
