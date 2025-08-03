package com.zad.excellence.practice.basic.deadlock;

public class CustomResource {

	private String resourceId;

	public CustomResource(String resourceId) {
		super();
		this.resourceId = resourceId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return resourceId;
	}
}
