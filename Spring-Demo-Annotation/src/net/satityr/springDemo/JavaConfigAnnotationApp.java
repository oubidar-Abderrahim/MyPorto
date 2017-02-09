package net.satityr.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigAnnotationApp {

	public static void main(String[] args) {

		// read the spring config from the config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the spring container
		Coach theCoach = context.getBean("thatCoach",Coach.class); 
		SwimCoach lastCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getWork());
		System.out.println(theCoach.getTheFortune());
		System.out.println(lastCoach.getWork());
		System.out.println(lastCoach.getTheFortune());
		System.out.println(lastCoach.getTeam());
		System.out.println(lastCoach.getEmail());
		
		// close the context
		context.close();
	}

}
