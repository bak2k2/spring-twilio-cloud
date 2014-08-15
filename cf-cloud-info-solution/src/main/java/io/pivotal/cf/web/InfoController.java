package io.pivotal.cf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class InfoController {

	@Autowired
	CloudInformationService cinfoService;

	@RequestMapping(method = RequestMethod.GET)
	public String showInfo(Model model) {

		// Get the environment
		model.addAttribute("env", System.getenv().entrySet());

		// Show services too - none if running locally
		model.addAttribute("services", cinfoService.getServices());

		// Show cloud-properties - none if running locally
		model.addAttribute("properties", cinfoService.getCloudProperties().entrySet());

		// Show application details
		model.addAttribute("appInfo", cinfoService.getApplicationInstanceInfo());
		
		return "info";
	}
}
