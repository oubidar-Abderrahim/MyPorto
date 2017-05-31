package com.utils;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Order;

public class testJPA {

	public static void main(String[] args) {
		
		displayProductNames();
	}
	
	public static void  displayProductNames(){
		
		  EntityManagerFactory emf =
			      Persistence.createEntityManagerFactory("jsfCrudMeDomain");
		  EntityManager em = emf.createEntityManager();
		  
		  //Order order = em.find(Order.class, 7);
		  
		  //  System.out.println(order.getProductName());
		  //List<Order> result = em.createQuery("SELECT o FROM Order o").getResultList();
		  //Query query = em.createQuery("SELECT o FROM Order o WHERE o.orderNo > :coucou");
		  //List<Order> result  = query.setParameter("coucou", 12).getResultList();
		  
		  List<Order> result =  em.createNamedQuery("getFirstOrder").getResultList();
		  System.out.println(result);
	}
}
