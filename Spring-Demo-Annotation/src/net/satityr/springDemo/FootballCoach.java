package net.satityr.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



// use the @component with the default id : in this case footballCoach
@Component
@Scope("prototype")
public class FootballCoach implements Coach {
	
	private FortuneService fortuneService ;
	
	public FootballCoach() {
		super();
	}

	// Create Setter method for the setter injection with auto-wiring
	// note that you can use any method to inject your bean, not necessarily a setter one, call it doSomeStuff and it will work just fine
	@Autowired
	@Qualifier("RESTFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	

	@Override
	public String getWork() {
		
		return "SHOOT the ball already!";
	}

	@Override
	public String getTheFortune() {
		
		return fortuneService.getFortune();
	}

}
