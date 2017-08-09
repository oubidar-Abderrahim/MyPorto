package net.satityr.springMVCdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funny")
public class FunnyController {

	@RequestMapping("/showForm")
	public String doSomeStuff(){
		return "look";
	}
	
}
