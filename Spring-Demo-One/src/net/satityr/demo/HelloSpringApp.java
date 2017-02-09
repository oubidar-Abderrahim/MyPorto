package net.satityr.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from container
		Coach myCoach = context.getBean("myCoach", Coach.class);
		Coach secondCoach = context.getBean("myCoach", Coach.class);
		CricketCoach myOtherCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on  the bean
		System.out.println(myCoach.getWork());
		System.out.println(myCoach.getFortune());
		System.out.println(myOtherCoach.getWork());
		System.out.println(myOtherCoach.getFortune());
		System.out.println(myOtherCoach.getEmail());
		System.out.println(myOtherCoach.getTeam());
		if(myCoach.equals(secondCoach))
			System.out.println("Singelton Scope");
		else
			System.out.println("Prototype Scope");
		
		// close the context
		context.close();
		
	}

}
