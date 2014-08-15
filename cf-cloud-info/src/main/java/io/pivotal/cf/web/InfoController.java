package io.pivotal.cf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A simple controller that returns information about the execution environment.
 */
@Controller
@RequestMapping("/")
public class InfoController {

	// TODO 4 - Dependency inject the CloudInformationService

	@RequestMapping(method = RequestMethod.GET)
	public String showInfo(Model model) {

		// TODO 5 - Get the environment using System.getenv().
		// Returns a Properties object, get the entrySet and add to the model as
		// attribute "env". If you aren't sure, look at info.html in
		// src/main/resources/templates to see how the Model data is being used.
		// The template is using Thymeleaf to generate dynamic output.

		// TODO 6 - Use the CloudInformationService to get service details
		// Add to the model as attribute "services".

		// TODO 7 - Use the CloudInformationService to get cloud properties.
		// Returns a Properties object, get the entrySet and add to the model as
		// attribute "properties".

		// TODO 8 - Use the CloudInformationService to get application instance
		// information and add to the Model as "appInfo"

		return "info";
	}
}
