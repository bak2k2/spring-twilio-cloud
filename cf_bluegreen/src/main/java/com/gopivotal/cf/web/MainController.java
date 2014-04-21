package com.gopivotal.cf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main(Model model) {
		
		String port = System.getenv("PORT");
		model.addAttribute("port", port);
		
		return "index";
	}
}
