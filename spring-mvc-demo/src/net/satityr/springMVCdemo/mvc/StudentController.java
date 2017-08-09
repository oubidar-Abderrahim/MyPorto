package net.satityr.springMVCdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a student
		Student student = new Student();

		// add student to model
		theModel.addAttribute("student", student);

		// add countryOptions to model
		theModel.addAttribute("theCountries", countryOptions);

		return "student-form";
	}

	@RequestMapping("/processStudentForm")
	public String processIt(@ModelAttribute("student") Student student) {

		// log the input
		System.out.println("the student " + student.getFirstName() + " " + student.getLastName() + " from "
				+ student.getCountry());

		return "student-confirmation";
	}

}
