package com.ihomefinder.api.resource;

import java.util.Date;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ScheduleShowingRequest extends Resource {
	
	public ScheduleShowingRequest(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ScheduleShowingRequest setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public ScheduleShowingRequest setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public String getListingId() {
		return this.getter("listingId", String.class);
	}
	
	public ScheduleShowingRequest setListingId(String listingId) {
		this.setter("listingId", listingId);
		return this;
	}
	
	public Date getCreatedOn() {
		return this.getter("createdOn", Date.class);
	}
	
	public ScheduleShowingRequest setCreatedOn(Date createdOn) {
		this.setter("createdOn", createdOn);
		return this;
	}
	
	public Date getPreferableOn() {
		return this.getter("preferableOn", Date.class);
	}
	
	public ScheduleShowingRequest setPreferableOn(Date preferableOn) {
		this.setter("preferableOn", preferableOn);
		return this;
	}
	
	public Date getAlternativeOn() {
		return this.getter("alternativeOn", Date.class);
	}
	
	public ScheduleShowingRequest setAlternativeOn(Date alternativeOn) {
		this.setter("alternativeOn", alternativeOn);
		return this;
	}
	
	public String getMessage() {
		return this.getter("message", String.class);
	}
	
	public ScheduleShowingRequest setMessage(String message) {
		this.setter("message", message);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public ScheduleShowingRequest setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	public Listing getListing() {
		return this.getter("listing", Listing.class);
	}
	
	public ScheduleShowingRequest setListing(Listing listing) {
		if(listing.isTransient()) {
			throw new UnsavedResourceException(listing);
		}
		this.setListingId(listing.getId());
		this.setter("listing", listing);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"subscriberId",
			"listingId",
			"createdOn",
			"preferableOn",
			"alternativeOn",
			"message"
		);
	}
	
}