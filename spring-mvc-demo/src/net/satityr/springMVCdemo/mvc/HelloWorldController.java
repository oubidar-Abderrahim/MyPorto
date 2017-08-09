package net.satityr.springMVCdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// controller method to show the initial form
	@RequestMapping("/showForm")
	public String ShowForm(){
		return "helloWorld-form";
	}
	
	// controller method to process the form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloWorld";
	}
	
	//  controller method to process and adding data to the model
	@RequestMapping("/processAndShout")
	public String ShoutOutLoud(HttpServletRequest request, Model model){
		
		// read the request parameter and convert it to uppercase
		StringBuilder theName = new StringBuilder( request.getParameter("studentName").toUpperCase() );

		// Creat message and adding it to the model
		model.addAttribute("message", "Yo! " + theName.toString());
		
		return "helloWorld";
	}
	
	//  controller method to process and adding data to the model without the request
	@RequestMapping("/processAndShoutAgain")
	public String ShoutAgain(@RequestParam("studentName") String theName, Model model){
		
		// read the request parameter and convert it to uppercase
		theName = theName.toUpperCase() ;

		// Creat message and adding it to the model
		model.addAttribute("message", "Hey Buddy! " + theName.toString());
		
		return "helloWorld";
	}
	
}
