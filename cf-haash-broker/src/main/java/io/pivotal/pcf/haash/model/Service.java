package io.pivotal.pcf.haash.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "services")
@JsonAutoDetect
public class Service {

	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private boolean bindable;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "service_id")
	private Set<Plan> plans = new HashSet<>();

	@Transient
	@JsonSerialize
	@JsonProperty("dashboard_client")
	private DashboardClient dashboardClient = new DashboardClient();

	@Transient
	@JsonSerialize
	private List<String> tags = Arrays.asList("the90s");

	@Transient
	@JsonSerialize
	private Metadata metadata = new Metadata();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isBindable() {
		return bindable;
	}

	public void setBindable(boolean bindable) {
		this.bindable = bindable;
	}

	public Set<Plan> getPlans() {
		return plans;
	}

	public void setPlans(Set<Plan> plans) {
		this.plans = plans;
	}

	public void addPlan(Plan plan) {
		this.plans.add(plan);
	}

	public DashboardClient getDashboardClient() {
		return dashboardClient;
	}

	public void setDashboardClient(DashboardClient dashboardClient) {
		this.dashboardClient = dashboardClient;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
