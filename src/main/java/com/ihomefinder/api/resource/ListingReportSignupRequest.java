package com.ihomefinder.api.resource;

import java.util.Date;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ListingReportSignupRequest extends Resource {
	
	public ListingReportSignupRequest(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ListingReportSignupRequest setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public ListingReportSignupRequest setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public Integer getListingReportId() {
		return this.getter("listingReportId", Integer.class);
	}
	
	public ListingReportSignupRequest setListingReportId(Integer listingReportId) {
		this.setter("listingReportId", listingReportId);
		return this;
	}
	
	public Date getCreatedOn() {
		return this.getter("createdOn", Date.class);
	}
	
	public ListingReportSignupRequest setCreatedOn(Date createdOn) {
		this.setter("createdOn", createdOn);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public ListingReportSignupRequest setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	public ListingReport getListingReport() {
		return this.getter("listingReport", ListingReport.class);
	}
	
	public ListingReportSignupRequest setListingReport(ListingReport listingReport) {
		if(listingReport.isTransient()) {
			throw new UnsavedResourceException(listingReport);
		}
		this.setListingReportId(listingReport.getId());
		this.setter("listingReport", listingReport);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"subscriberId",
			"listingReportId",
			"createdOn"
		);
	}
	
}