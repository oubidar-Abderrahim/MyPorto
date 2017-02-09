package net.satityr.springDemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	


	private FortuneService fortuneService;
	
	// field injection
	@Value("${kof.email}")
	private String email;
	
	@Value("${kof.team}")
	private String team;

	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getWork() {
		
		return "play in water, i hope you drown";
	}

	@Override
	public String getTheFortune() {
		
		return fortuneService.getFortune();
	}

}
