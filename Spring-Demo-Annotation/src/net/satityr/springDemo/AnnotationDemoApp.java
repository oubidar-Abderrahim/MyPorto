package net.satityr.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the spring container
		Coach theCoach = context.getBean("thatCoach",Coach.class); 
		Coach myCoach = context.getBean("footballCoach", Coach.class);
		Coach aCoach = context.getBean("rugbyCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getWork());
		System.out.println(theCoach.getTheFortune());
		System.out.println(myCoach.getWork());
		System.out.println(myCoach.getTheFortune());
		System.out.println(aCoach.getWork());
		System.out.println(aCoach.getTheFortune());
		
		// close the context
		context.close();
	}

}
