package net.satityr.demo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService ;
	private String email ;
	private String team ;
	
	
	// add initiation method
	public void initCoach(){
		System.out.println("start");
	}

	// add destruction method
	public void destroyCoach(){
		System.out.println("bye bye!");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public CricketCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	public CricketCoach() {
		super();
	}

	@Override
	public String getWork() {
		
		return "Cricket : rest for the time being";
	}

	@Override
	public String getFortune() {
	
		return fortuneService.getFortune();
	}

}
