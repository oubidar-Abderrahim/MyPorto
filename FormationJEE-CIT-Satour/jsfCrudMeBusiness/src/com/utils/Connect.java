package com.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.utils.HibernateUtil;
import model.*;
public class Connect {

	
	public static void main(String[] args) {
	//	testSave();
		displayProductNames();
	}
	
	public static void testSave() {
		
		  SessionFactory sf = HibernateUtil.getSessionFactory(); 
		  Session session = sf.openSession();
		  
		  Order order = new Order();
		  order.setPrice(10010);
		  order.setProductName("hihelibnamcrlio");
		  order.setQty(10);
		  order.setCategory(getOneCategory());
		  
		  Transaction tx = session.beginTransaction(); 
		  session.saveOrUpdate(order ); 
		  
		  tx.commit();
		 
		 
	}
	
	public static  Category getOneCategory(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Category cat= (Category) session.createQuery("from Category").list().get(0);

		session.close();
		return cat;
	}
	
	@SuppressWarnings("unchecked")
	public static void  displayProductNames(){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		List<Order> orders = session.createQuery("from Order").list();

		session.close();
		
		for(Order order : orders){
			System.out.println(order.getProductName());
		}
	}

}
