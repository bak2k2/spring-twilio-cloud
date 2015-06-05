package io.pivotal.pcf.haash.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Metadata {

	private String displayName = "HaaSh";
	private String imageUrl = "https://d33na3ni6eqf5j.cloudfront.net/app_resources/18492/thumbs_112/img9069612145282015279.png";
	private String longDescription = "Natedogg, in the cloud";
	private String providerDisplayName = "21 and Lewis";
	private String documentationUrl = "http://docs.example.com";
	private String supportUrl = "http://www.example.com/";

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getProviderDisplayName() {
		return providerDisplayName;
	}

	public void setProviderDisplayName(String providerDisplayName) {
		this.providerDisplayName = providerDisplayName;
	}

	public String getDocumentationUrl() {
		return documentationUrl;
	}

	public void setDocumentationUrl(String documentationUrl) {
		this.documentationUrl = documentationUrl;
	}

	public String getSupportUrl() {
		return supportUrl;
	}

	public void setSupportUrl(String supportUrl) {
		this.supportUrl = supportUrl;
	}

}
