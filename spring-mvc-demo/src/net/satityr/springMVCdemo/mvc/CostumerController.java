package net.satityr.springMVCdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/costumer")
public class CostumerController {
	
	@RequestMapping("/showForm")
	public String showPage(Model theModel) {
  
    theModel.addAttribute("costumer", new Costumer());
		return "costumer-form";
		
	}
  
  // using spring & hibernate validator
  
  @RequestMapping("/processForm")
	public String processIt(@ModelAttribute("student") Student student) {

    // more code coming soon

		return "student-confirmation";
	}

}
