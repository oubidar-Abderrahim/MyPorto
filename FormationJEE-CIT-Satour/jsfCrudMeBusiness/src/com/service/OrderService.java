package com.service;

import java.util.List;

import model.Order;

public interface OrderService {

	Order createOrder(Order o);
	Order UpdateOrder(Order o);
	List<Order> getAllOrders();
	void deleteOrder(Integer id);

	boolean verifyFirstUserName(String name);
	
}
