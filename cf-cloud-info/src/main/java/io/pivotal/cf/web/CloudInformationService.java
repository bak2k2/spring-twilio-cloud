package io.pivotal.cf.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.app.BasicApplicationInstanceInfo;
import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.stereotype.Service;

/**
 * A service providing information about the current Cloud environment. Returns
 * null data when not deployed to a Cloud.
 */
@Service
public class CloudInformationService {

	/**
	 * Information about the cloud, may be null if running off-cloud.
	 */
	private Cloud cloud;

	@Autowired(required = false)
	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}

	public List<ServiceInfo> getServices() {
		List<ServiceInfo> services = null;

		// TODO 1 - If the cloud is non-null, return the serviceInfo collection
		// Otherwise return a set with a single ServiceInfo item - create a
		// BaseServiceInfo with id "None".

		return services;
	}

	public ApplicationInstanceInfo getApplicationInstanceInfo() {
		// TODO 2 - Return the application instance info
		// If the cloud variable is null, return a BasicApplicationInstanceInfo
		// with instanceId "0", applicationId of "local" and an empty set of
		// properties.

		return null;
	}

	public Properties getCloudProperties() {
		// TODO 3 - If cloud is non-null return the cloud properties otherwise
		// return an empty set of properties
		return null;
	}
}
