package io.pivotal.cf;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Get the Cloud object. This class does not extend <tt>AbstractCloudConfig</tt>
 * so that it can run on or off a cloud. Classes that extend
 * <tt>AbstractCloudConfig</tt> fail when the application is not run in a cloud
 * environment. Doing it this way, allows the application to be tested running
 * locally.
 */
@Configuration
public class CloudConfiguration {

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
