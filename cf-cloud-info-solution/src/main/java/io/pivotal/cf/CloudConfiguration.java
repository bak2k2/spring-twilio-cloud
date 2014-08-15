package io.pivotal.cf;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CloudConfiguration { // extends AbstractCloudConfig {

	@Profile("cloud")
	@Bean(name = "cloud")
	public Cloud getCloud() {
		try {
			return new CloudFactory().getCloud();
		} catch (CloudException e) {

			return null;
		}
	}
}
