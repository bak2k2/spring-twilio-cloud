package io.pivotal.cf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.app.BasicApplicationInstanceInfo;
import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Java Configuration class that returns runtime information when NOT running in
 * a Cloud environment, making it available as 3 Spring Beans: Bound Services,
 * Application/Instance information and Cloud Properties. This config will be
 * used if no other Profile is active (for example when running locally).
 */
// TODO 01 - Note this configuration file and the three beans that are defined.
//           Also notice the usage of the default profile; this profile is
//           only activated if no other profile is in use.
//           Move onto the next step.

// TODO 02 - Run the application locally - Run As ... Spring Boot App.
//           Open http://localhost:8080 in a browser.  The application should
//           work but the web-page is mostly empty, except for the Environment
//           section.
//           Now lets make it Cloud aware - go to next step.
@Configuration
@Profile("default")
public class ConfigDefault {

	@Bean
	public List<ServiceInfo> boundServices() {
		List<ServiceInfo> services = new ArrayList<ServiceInfo>();
		services.add(new BaseServiceInfo("None"));
		return services;
	}

	@Bean
	public ApplicationInstanceInfo applicationInstanceInfo() {
		return new BasicApplicationInstanceInfo("0", "local",
				new HashMap<String, Object>());
	}

	@Bean
	public Properties cloudProperties() {
		return new Properties();
	}

}
