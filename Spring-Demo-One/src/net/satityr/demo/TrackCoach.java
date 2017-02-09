package net.satityr.demo;

public class TrackCoach implements Coach {
	
	
	private FortuneService fortuneService ;
	
	

	public TrackCoach() {
		super();
	}


	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	
	public String getWork() {
		return "track : run 5 Km !";
	}

	
	public String getFortune() {
		
		return fortuneService.getFortune();
	}

}
