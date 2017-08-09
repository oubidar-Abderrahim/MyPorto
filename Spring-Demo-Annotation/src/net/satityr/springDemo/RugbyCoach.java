package net.satityr.springDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



// use the @component with the default id : in this case rugbyCoach
@Component
public class RugbyCoach implements Coach {
	
	// use the auto-wiring directly on the field by using "reflection"
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService ;

	@Override
	public String getWork() {
		
		return "run a 2Km and take the day off";
	}

	@Override
	public String getTheFortune() {
		
		return fortuneService.getFortune();
	}
	
	// my init method
	@PostConstruct
	public void initCoach(){
		System.out.println("initialization after the constructor");
	}
	
	// my destroy method (doesn't work with prototype scope)
	@PreDestroy
	public void destroyCoach(){
		System.out.println("before destroying the bean");
	}

}
