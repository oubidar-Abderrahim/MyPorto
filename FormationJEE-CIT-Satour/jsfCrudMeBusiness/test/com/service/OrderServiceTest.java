package com.service;

import static org.junit.Assert.*;

import java.util.List;

import model.Order;

import org.junit.Test;

public class OrderServiceTest {

	OrderService orderService  = new OrderServiceImpl(); 

	@Test
	public void testGetAllOrders() {
		
		List<Order> list = orderService.getAllOrders();
		assertTrue(list != null);
		assertTrue(list.size() >0);
	}

	@Test
	public void testUpdateOrder() {
		
		Order o = orderService.getAllOrders().get(0);
		o.setProductName("FFFFFFFFFFFFFF");
		
		o = orderService.UpdateOrder(o);
		
		assertNotNull(o);
		assertEquals("FFFFFFFFFFFFFF", o.getProductName());
		
	}

	@Test
	public void testDeleteOrder() {
		
		int listSize1 = orderService.getAllOrders().size();
		
		orderService.deleteOrder(7);
		int listSize2 = orderService.getAllOrders().size();
		listSize2++;
		assertEquals(listSize1 , listSize2);
		
	}

	@Test
	public void testVerifyFirstUserName() {
		
	}

}
