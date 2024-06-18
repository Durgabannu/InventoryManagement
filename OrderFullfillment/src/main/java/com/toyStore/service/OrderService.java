package com.toyStore.service;
import java.util.List;
import com.toyStore.model.Order;
public interface OrderService {

	Order placeOrder(Order order);

	Order getOrderById(Long id);

	List<Order> getAllOrders();

	void updateOrder(Order order);

	void deleteOrder(Long id);
}
