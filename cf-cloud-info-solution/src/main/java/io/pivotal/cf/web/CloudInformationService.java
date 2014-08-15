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

@Service
public class CloudInformationService {

	private Cloud cloud;

	@Autowired(required = false)
	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}

	public List<ServiceInfo> getServices() {
		if (cloud != null && cloud.getServiceInfos().size() > 0) {
			return cloud.getServiceInfos();
		} else {
			List<ServiceInfo> services = new ArrayList<ServiceInfo>();
			services.add(new BaseServiceInfo("None"));
			return services;
		}
	}

	public ApplicationInstanceInfo getApplicationInstanceInfo() {
		return cloud == null ? new BasicApplicationInstanceInfo("0", "local",
				new HashMap<String, Object>()) : cloud
				.getApplicationInstanceInfo();
	}

	public Properties getCloudProperties() {
		return cloud != null ? cloud.getCloudProperties() : new Properties();
	}
}
