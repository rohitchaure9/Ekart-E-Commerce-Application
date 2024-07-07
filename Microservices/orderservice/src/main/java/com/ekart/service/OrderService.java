package com.ekart.service;

import java.util.List;

import com.ekart.entity.Order;

public interface OrderService {
	String placeOrder(int userId);
	String cancelOrder(int userId, int prodId);
	List<Order> getAllOrdersByUserId(int userId);

}
