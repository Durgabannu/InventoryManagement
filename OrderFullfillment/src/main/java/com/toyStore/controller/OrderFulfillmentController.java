package com.toyStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyStore.model.Order;
import com.toyStore.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderFulfillmentController {
	 @Autowired
	    private OrderService orderService;

	    @PostMapping("/place")
	    public ResponseEntity<?> createOrder(@RequestBody Order order) {
	        try {
	            Order createdOrder = orderService.placeOrder(order);
	            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Order could not be created", HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
	        try {
	            Order order = orderService.getOrderById(id);
	            if (order != null) {
	                return new ResponseEntity<>(order, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred while fetching the order", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Order>> getAllOrders() {
	        List<Order> orders = orderService.getAllOrders();
	        return ResponseEntity.ok(orders);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Void> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
	        order.setId(id);
	        orderService.updateOrder(order);
	        return ResponseEntity.ok().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
	        orderService.deleteOrder(id);
	        return ResponseEntity.ok().build();
	    }

}
