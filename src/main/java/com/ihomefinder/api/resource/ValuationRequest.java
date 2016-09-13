package com.ihomefinder.api.resource;

import java.util.Date;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ValuationRequest extends Resource {
	
	public ValuationRequest(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ValuationRequest setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public ValuationRequest setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public Date getCreatedOn() {
		return this.getter("createdOn", Date.class);
	}
	
	public ValuationRequest setCreatedOn(Date createdOn) {
		this.setter("createdOn", createdOn);
		return this;
	}
	
	public String getMessage() {
		return this.getter("message", String.class);
	}
	
	public ValuationRequest setMessage(String message) {
		this.setter("message", message);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public ValuationRequest setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"subscriberId",
			"createdOn",
			"message"
		);
	}
	
}