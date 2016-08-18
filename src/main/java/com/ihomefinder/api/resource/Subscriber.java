package com.ihomefinder.api.resource;

import com.ihomefinder.api.Resource;
import com.ihomefinder.api.ResourceWrapper;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class Subscriber extends Resource {
	
	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public Subscriber setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getClientId() {
		return this.getter("clientId", Integer.class);
	}
	
	public Subscriber setClientId(Integer clientId) {
		this.setter("clientId", clientId);
		return this;
	}
	
	public Integer getAgentId() {
		return this.getter("agentId", Integer.class);
	}
	
	public Subscriber setAgentId(Integer agentId) {
		this.setter("agentId", agentId);
		return this;
	}
	
	public String getFirstName() {
		return this.getter("firstName", String.class);
	}
	
	public Subscriber setFirstName(String firstName) {
		this.setter("firstName", firstName);
		return this;
	}
	
	public String getLastName() {
		return this.getter("lastName", String.class);
	}
	
	public Subscriber setLastName(String lastName) {
		this.setter("lastName", lastName);
		return this;
	}
	
	public String getEmail() {
		return this.getter("email", String.class);
	}
	
	public Subscriber setEmail(String email) {
		this.setter("email", email);
		return this;
	}
	
	public String getPassword() {
		return this.getter("password", String.class);
	}
	
	public Subscriber setPassword(String password) {
		this.setter("password", password);
		return this;
	}
	
	public String getPhone() {
		return this.getter("phone", String.class);
	}
	
	public Subscriber setPhone(String phone) {
		this.setter("phone", phone);
		return this;
	}
	
	public String getAddress() {
		return this.getter("address", String.class);
	}
	
	public Subscriber setAddress(String address) {
		this.setter("address", address);
		return this;
	}
	
	public String getCity() {
		return this.getter("city", String.class);
	}
	
	public Subscriber setCity(String city) {
		this.setter("city", city);
		return this;
	}
	
	public String getState() {
		return this.getter("state", String.class);
	}
	
	public Subscriber setState(String state) {
		this.setter("state", state);
		return this;
	}
	
	public String getZip() {
		return this.getter("zip", String.class);
	}
	
	public Subscriber setZip(String zip) {
		this.setter("zip", zip);
		return this;
	}
	
	/**
	 * @return \Ihomefinder\Api\Client
	 */
	public Client getClient() {
		return this.getter("client", Client.class);
	}
	
	public Subscriber setClient(Client client) {
		this.setter("client", client);
		return this;
	}
	
	/**
	 * @return \Ihomefinder\Api\Agent
	 */
	public Agent getAgent() {
		return this.getter("agent", Agent.class);
	}
	
	public Subscriber setAgent(Agent agent) {
		if(ResourceWrapper.getInstance(agent).isTransient()) {
			throw new UnsavedResourceException(agent);
		}
		this.setAgentId(agent.getId());
		this.setter("agent", agent);
		return this;
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"id",
			"clientId",
			"agentId",
			"firstName",
			"lastName",
			"email",
			"password",
			"phone",
			"address",
			"city",
			"state",
			"zip",
		};
	}
	
}