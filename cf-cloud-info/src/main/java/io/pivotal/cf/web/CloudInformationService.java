package io.pivotal.cf.web;

import io.pivotal.cf.CloudConfiguration;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.stereotype.Service;

/**
 * A service providing information about the current Cloud environment. Returns
 * sensible null data when not deployed to a Cloud, allowing the application to
 * be tested locally.
 */
@Service
public class CloudInformationService {

	/**
	 * Information about the cloud, may be null if running off-cloud.
	 */
	private Cloud cloud = null;

	/**
	 * If running locally, this will quietly not be invoked. If deployed to
	 * Cloud Foundry, it will be called automatically.
	 * 
	 * @param cloud
	 * @see CloudConfiguration#getCloud()
	 */
	@Autowired(required = false)
	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}

	/**
	 * Get a list of available services.
	 * 
	 * @return A non-null list that may be empty.
	 */
	public List<ServiceInfo> getServices() {
		List<ServiceInfo> services = null;

		// TODO 01 - Spring Cloud only provides a Cloud instance if running in a
		// cloud. We would like to run an application both locally and in the
		// cloud. This class wraps the Cloud object to enable this
		//
		// Check if the cloud data-member is non-null, use it to return the
		// serviceInfo collection.
		// Otherwise return an ArrayList containing a single ServiceInfo item -
		// create a BaseServiceInfo with id "None".

		// if (cloud != null) services = ... else ...

		return services;
	}

	/**
	 * Get information about the current application instance.
	 * 
	 * @return
	 */
	public ApplicationInstanceInfo getApplicationInstanceInfo() {
		// TODO 02 - Return the application instance info. However if the
		// cloud data-member is null, return a BasicApplicationInstanceInfo
		// with instanceId "0", applicationId of "local" and an empty set of
		// properties.

		return null;
	}

	/**
	 * Get the Cloud properties.
	 *
	 * @return A non-null Java properties object. If not running in a Cloud,
	 *         this will be empty.
	 */
	public Properties getCloudProperties() {
		// TODO 03 - If cloud is non-null return the cloud properties otherwise
		// return an empty set of properties
		return null;
	}

}
