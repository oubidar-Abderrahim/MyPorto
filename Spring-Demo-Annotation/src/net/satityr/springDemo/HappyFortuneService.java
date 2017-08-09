package net.satityr.springDemo;

import org.springframework.stereotype.Component;




@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Be Happy :D !!";
	}

}
