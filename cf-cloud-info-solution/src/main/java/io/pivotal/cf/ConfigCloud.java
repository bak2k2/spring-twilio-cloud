package io.pivotal.cf;

import java.util.List;
import java.util.Properties;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Java Configuration class that fetches the runtime information when running in
 * a Cloud environment and makes it available as 3 Spring Beans: Bound Services,
 * Application/Instance information and Cloud Properties.
 */
@Configuration
// TODO 03 - Make this configuration class active when running in a 'cloud'
//           environment (hint: use a Spring profile)
@Profile("cloud")
public class ConfigCloud {

	/**
	 * Return The Spring Cloud meta-data object.
	 * 
	 * @return The Cloud object for the current environment or null if not
	 *         running in a known cloud environment
	 */
	@Bean
	public Cloud cloud() {
		try {
			return new CloudFactory().getCloud();
		} catch (CloudException e) {
			// Not running in a known cloud environment
			return null;
		}
	}

	// TODO 04 - Create a Spring @Bean method named boundServices.
	//           Its signature should match the method of the same name in the
	//           ConfigDefault class.
	//           It should call the cloud() method to obtain the cloud, then
	//           obtain and return a List of ServiceInfos.
	@Bean
	public List<ServiceInfo> boundServices() {
		return cloud().getServiceInfos();
	}

	// TODO 05 - Create a Spring @Bean method named applicationInstanceInfo.
	//           Its signature should match the method of the same name in the
	//           ConfigDefault class.
	//           It should call the cloud() method to obtain the cloud, then obtain
	//           and return the ApplicationInstanceInfo.
	@Bean
	public ApplicationInstanceInfo applicationInstanceInfo() {
		return cloud().getApplicationInstanceInfo();
	}

	// TODO 06 - Create a Spring @Bean method named cloudProperties.
	//           Its signature should match the method of the same name in the
	//           ConfigDefault class.
	//           It should call the cloud() method to obtain the cloud, then obtain
	//           and return the Cloud Properties.
	@Bean
	public Properties cloudProperties(Cloud cloud) {
		return cloud.getCloudProperties();
	}

}