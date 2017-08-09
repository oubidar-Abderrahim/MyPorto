package com.tests;

import com.service.OrderService;
import com.service.OrderServiceImpl;

public class mainTest {

	public static void main(String[] args) {
		
		OrderService orderService = new OrderServiceImpl();
		System.out.print(orderService.getAllOrders());
	}

}
