package com.service;

import java.util.List;

import com.dao.order.OrderDAOImpl;
import model.Order;

public class OrderServiceImpl implements OrderService {

	OrderDAOImpl orderDAO = new OrderDAOImpl();
	
	@Override
	public Order createOrder(Order o) {
		return orderDAO.create(o);
	}

	@Override
	public Order UpdateOrder(Order o) {
		return orderDAO.update(o);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.findAll();
	}

	@Override
	public void deleteOrder(Integer id) {
		orderDAO.delete(id);
		
	}

	@Override
	public boolean verifyFirstUserName(String name) {
		
		List<Order> listOrders =  orderDAO.findAll();
		for(Order o : listOrders){
			return o.getProductName().equals(name); 
		}
		return false;
	}

}
