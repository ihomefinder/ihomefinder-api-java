package com.ihomefinder.api.resource;

import com.ihomefinder.api.Resource;

public class Office extends Resource {
	
	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public Office setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public String getName() {
		return this.getter("name", String.class); 
	}
	
	public Office setName(String name) {
		this.setter("name", name);
		return this;
	}
	
	public String getEmail() {
		return this.getter("email", String.class);
	}
	
	public Office setEmail(String email) {
		this.setter("email", email);
		return this;
	}
	
	public String getAddress() {
		return this.getter("address", String.class);
	}
	
	public Office setAddress(String address) {
		this.setter("address", address);
		return this;
	}
	
	public String getCity() {
		return this.getter("city", String.class);
	}
	
	public Office setCity(String city) {
		this.setter("city", city);
		return this;
	}
	
	public String getState() {
		return this.getter("state", String.class);
	}
	
	public Office setState(String state) {
		this.setter("state", state);
		return this;
	}
	
	public String getZip() {
		return this.getter("zip", String.class);
	}
	
	public Office setZip(String zip) {
		this.setter("zip", zip);
		return this;
	}
	
	/**
	 * @return \Ihomefinder\Api\Resource\Agents
	 */
	public Agents getAgents() {
		return this.getter("agents", Agents.class);
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"id",
			"name",
			"email",
			"address",
			"city",
			"state",
			"zip",
		};
	}
	
}