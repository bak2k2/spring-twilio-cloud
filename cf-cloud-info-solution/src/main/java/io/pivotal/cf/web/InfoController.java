package io.pivotal.cf.web;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A simple controller that returns information about the current execution
 * environment. Uses Thymeleaf to display the data - to see how, use an editor
 * to view: <tt>src/main/resources/templates/info.html</tt>.
 */
@Controller
@RequestMapping("/")
public class InfoController {

	// TODO 07 - Note how this controller uses dependency injection to obtain
	//	         the beans. This controller does not know if we are in a cloud
	//           or non-cloud environment.
	// TODO 08 - Push to the cloud and view the home-page.  Now all sections
	//           of the page should contain information, except Services.
	
	// TODO 09 - OPTIONAL BONUS STEP
	//           Bind a service, any service (it won't be used) to the
	//           application, restart and once running, refresh the home-page.
	//           Now all sections should contain data, including Services.
	@Resource(name="boundServices") List<ServiceInfo> serviceInfoList;
	@Autowired ApplicationInstanceInfo applicationInstanceInfo;
	@Autowired Properties cloudProperties;

	@RequestMapping(method = RequestMethod.GET)
	public String showInfo(Model model) {

		// Get environment variables and use to populate a sorted map
		Map<String, String> env = new TreeMap<String, String>(System.getenv());

		model.addAttribute("projectName", "cf-cloud-info-solution");
		model.addAttribute("env", env.entrySet());
		model.addAttribute("services",serviceInfoList);
		model.addAttribute("properties",cloudProperties.entrySet());
		model.addAttribute("appInfo",applicationInstanceInfo);
		
		return "info";  // Template (view) name
	}
}
