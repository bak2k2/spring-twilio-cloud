package io.pivotal.pcf.haash.model;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonAutoDetect
public class PlanMetadata {

	private List<String> bullets = Arrays.asList("LBC");
	@JsonRawValue
	private String costs = "[{\"amount\":{\"usd\":0,\"eur\":0},\"unit\":\"MONTHLY\"}]";
	private String displayName = "Eastside of the LBC";

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCosts() {
		return costs;
	}

	public void setCosts(String costs) {
		this.costs = costs;
	}

	public List<String> getBullets() {
		return bullets;
	}

	public void setBullets(List<String> bullets) {
		this.bullets = bullets;
	}
}
