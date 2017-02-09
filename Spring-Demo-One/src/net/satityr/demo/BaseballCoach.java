package net.satityr.demo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService ;

	
	
	public BaseballCoach() {
		super();
	}


	public BaseballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	

	public String getWork() {
		return "baseball : 30 min batting";
	}

	public String getFortune() {
		
		return fortuneService.getFortune();
	}
	
	


}
