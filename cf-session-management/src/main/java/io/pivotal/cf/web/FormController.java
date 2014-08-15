package io.pivotal.cf.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FormController {

	@RequestMapping(method=RequestMethod.GET)
	public String showForm() {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String showResults (
			HttpSession session, 
			@RequestParam String name, 
			@RequestParam String desc) {

		//	Unfortunate code: Session use ...
		session.setAttribute("name", name);
		session.setAttribute("desc", desc);
		return "redirect:results";
	}
}
