package net.satityr.springDemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Life is miserable :(";
	}

}
