package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class Agent extends Resource {
	
	public Agent(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public Agent setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getOfficeId() {
		return this.getter("officeId", Integer.class);
	}
	
	public Agent setOfficeId(Integer officeId) {
		this.setter("officeId", officeId);
		return this;
	}
	
	public String getFirstName() {
		return this.getter("firstName", String.class); 
	}
	
	public Agent setFirstName(String firstName) {
		this.setter("firstName", firstName);
		return this;
	}
	
	public String getLastName() {
		return this.getter("lastName", String.class);
	}
	
	public Agent setLastName(String lastName) {
		this.setter("lastName", lastName);
		return this;
	}
	
	public String getEmailAddress() {
		return this.getter("emailAddress", String.class);
	}
	
	public Agent setEmailAddress(String emailAddress) {
		this.setter("emailAddress", emailAddress);
		return this;
	}
	
	public String getAddress() {
		return this.getter("address", String.class);
	}
	
	public Agent setAddress(String address) {
		this.setter("address", address);
		return this;
	}
	
	public String getCity() {
		return this.getter("city", String.class);
	}
	
	public Agent setCity(String city) {
		this.setter("city", city);
		return this;
	}
	
	public String getState() {
		return this.getter("state", String.class);
	}
	
	public Agent setState(String state) {
		this.setter("state", state);
		return this;
	}
	
	public String getPostalCode() {
		return this.getter("postalCode", String.class);
	}
	
	public Agent setPostalCode(String postalCode) {
		this.setter("postalCode", postalCode);
		return this;
	}
	
	public Office getOffice() {
		return this.getter("office", Office.class);
	}
	
	public Agent setOffice(Office office) {
		if(office.isTransient()) {
			throw new UnsavedResourceException(office);
		}
		this.setOfficeId(office.getId());
		this.setter("office", office);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"officeId",
			"firstName",
			"lastName",
			"emailAddress",
			"address",
			"city",
			"state",
			"postalCode"
		);
	}
	
}