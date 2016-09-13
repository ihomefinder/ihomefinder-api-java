package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class Office extends Resource {
	
	public Office(Authentication auth) {
		super(auth);
	}

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
	
	public String getEmailAddress() {
		return this.getter("emailAddress", String.class);
	}
	
	public Office setEmailAddress(String emailAddress) {
		this.setter("emailAddress", emailAddress);
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
	
	public String getPostalCode() {
		return this.getter("postalCode", String.class);
	}
	
	public Office setPostalCode(String postalCode) {
		this.setter("postalCode", postalCode);
		return this;
	}
	
	public Agents getAgents() {
		return this.getter("agents", Agents.class);
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"name",
			"emailAddress",
			"address",
			"city",
			"state",
			"postalCode"
		);
	}
	
}