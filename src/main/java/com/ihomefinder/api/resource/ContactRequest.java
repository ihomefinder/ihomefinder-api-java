package com.ihomefinder.api.resource;

import java.util.Date;

import com.ihomefinder.api.Resource;
import com.ihomefinder.api.ResourceWrapper;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ContactRequest extends Resource {
	
	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ContactRequest setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public ContactRequest setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public Date getCreatedOn() {
		return this.getter("createdOn", Date.class);
	}
	
	public ContactRequest setCreatedOn(Date createdOn) {
		this.setter("createdOn", createdOn);
		return this;
	}
	
	public String getMessage() {
		return this.getter("message", String.class);
	}
	
	public ContactRequest setMessage(String message) {
		this.setter("message", message);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public ContactRequest setSubscriber(Subscriber subscriber) {
		if(ResourceWrapper.getInstance(subscriber).isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"id",
			"subscriberId",
			"createdOn",
			"message",
		};
	}
	
}