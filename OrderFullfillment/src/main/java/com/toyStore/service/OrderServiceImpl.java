package com.toyStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyStore.model.Order;
import com.toyStore.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	 @Autowired
	    private OrderRepository orderRepository;

	    @Override
	    public Order placeOrder(Order order) {
	        return orderRepository.save(order);
	    }

	    @Override
	    public Order getOrderById(Long id) {
	        return orderRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    @Override
	    public void updateOrder(Order order) {
	        orderRepository.save(order);
	    }

	    @Override
	    public void deleteOrder(Long id) {
	        orderRepository.deleteById(id);
	    }
	
}