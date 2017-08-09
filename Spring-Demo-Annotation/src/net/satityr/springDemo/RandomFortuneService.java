package net.satityr.springDemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component 
public class RandomFortuneService implements FortuneService {
	
	private String[] randomFortunes = new String[] {"Be cool 8|","In love <3","nah! :/","R U kidding -_-","bla bla bla :v"};
	private Random ran = new Random();

	@Override
	public String getFortune() {
		
		
		int i = ran.nextInt(randomFortunes.length);
		return randomFortunes[i];
	}

}
