package net.satityr.springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;



// configuration class to replace xml
@Configuration
@ComponentScan("net.satityr.springDemo")
@PropertySource("classpath:infor.properties")
public class SportConfig {
	
	
	// add support for ${...}
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	

	// define bean for SadFortuneService
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}
	
	
	// define bean for SwimCoach
	@Bean
	public Coach swimCoach(){
		return new SwimCoach(sadFortuneService());
	}
	
	// inject dependencies for our coach
	
}
