package net.satityr.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



// use Annotation with a specific ID : thatCoach
@Component("thatCoach")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService ;
	
	// create a constructor for constructor injection by using the Auto-wiring 
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		// Qualifier is inside the parameter of the constructor
		super();
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getWork() {
		
		return "practice backhand volley";
	}

	

	@Override
	public String getTheFortune() {
		
		return fortuneService.getFortune();
	}

}
