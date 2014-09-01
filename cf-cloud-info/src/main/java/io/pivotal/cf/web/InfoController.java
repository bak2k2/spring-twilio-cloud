package io.pivotal.cf.web;

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

	// TODO 04 - Dependency inject the CloudInformationService

	@RequestMapping(method = RequestMethod.GET)
	public String showInfo(Model model) {

		// TODO 05 - Get the environment using System.getenv().
		// Returns a Properties object, get the entrySet and add to the model as
		// attribute "env". If you aren't sure, look at info.html in
		// src/main/resources/templates to see how the Model data is being used.
		// The template is using Thymeleaf to generate dynamic output.

		// TODO 06 - Use the CloudInformationService to get service details
		// Add to the model as attribute "services".

		// TODO 07 - Use the CloudInformationService to get cloud properties.
		// Returns a Properties object, get the entrySet and add to the model as
		// attribute "properties".

		// TODO 08 - Use the CloudInformationService to get application instance
		// information and add to the Model as "appInfo"

		// TODO 09 - Run the application locally and see what you see on the
		//          home page: http://localhost:8080
		
		// TODO 10 - Push to Cloud Foundry and view home page again

		// TODO 11 - EXTRA CREDIT BONUS
		//           Bind a service (any service) to your application and
		//           refresh the page in the browser.  If nothing seems to
		//           have changed, try stopping and starting the application.

		return "info";
	}
}
