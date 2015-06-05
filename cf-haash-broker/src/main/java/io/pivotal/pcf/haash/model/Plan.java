package io.pivotal.pcf.haash.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "plans")
@JsonAutoDetect
public class Plan {

	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Transient
	@JsonSerialize
	@JsonProperty("metadata")
	private PlanMetadata planMetadata = new PlanMetadata();

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
}
