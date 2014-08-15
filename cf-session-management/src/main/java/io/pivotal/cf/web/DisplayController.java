package io.pivotal.cf.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Show the session data and the port number.
 */
@Controller
public class DisplayController {

	//@Autowired
	//List<ServiceInfo> services;

	@RequestMapping("/results")
	public String displayResults(Model model, HttpSession session,
			HttpServletRequest req) {

		// Unfortunate code: Session use ...
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("desc", session.getAttribute("desc"));

		// If running on Cloud Foundry, port is in the environment
		// If running locally, ask the HttpServletRequest
		String port = System.getenv("PORT");
		model.addAttribute("port",
				StringUtils.isEmpty(port) ? req.getServerPort() : port);

		// Show services too - none if running locally
		model.addAttribute("services", getServices());

		return "display";
	}
	
	protected List<ServiceInfo> getServices() {
		try {
			Cloud cloud = new CloudFactory().getCloud();
			return cloud.getServiceInfos();
		} catch (CloudException e) {

			List<ServiceInfo> services = new ArrayList<ServiceInfo>();
			services.add(new BaseServiceInfo("None"));
			return services;
		}
	}
}
