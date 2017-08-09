package net.satityr.springMVCdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	
	
	private String firstName ;
	private String lastName ;
	private String country ;
	private LinkedHashMap<String, String> countryOptions ;
	private String favoriteLanguage ;
	private String[] operatingSystem ;
	
	
	public Student() {
		super();
		
		// populate country options 
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("Germany", "Germany");
		countryOptions.put("Japan", "Japan");
		countryOptions.put("Morocco", "Morocco");
		countryOptions.put("Russia", "Russia");
		countryOptions.put("United Kingdom", "United Kingdom");
		
	}

	
	
	public String[] getOperatingSystem() {
		return operatingSystem;
	}



	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}



	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}



	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;	
	}



	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	
	
	

}
