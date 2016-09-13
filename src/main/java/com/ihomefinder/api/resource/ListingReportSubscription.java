package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.Savable;
import com.ihomefinder.api.Url;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ListingReportSubscription extends Resource implements Savable<ListingReportSubscription> {
	
	public ListingReportSubscription(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ListingReportSubscription setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getListingReportId() {
		return this.getter("listingReportId", Integer.class);
	}
	
	public ListingReportSubscription setListingReportId(Integer listingReportId) {
		this.setter("listingReportId", listingReportId);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public ListingReportSubscription setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public ListingReport getListingReport() {
		return this.getter("listingReport", ListingReport.class);
	}
	
	public ListingReportSubscription setListingReport(ListingReport listingReport) {
		if(listingReport.isTransient()) {
			throw new UnsavedResourceException(listingReport);
		}
		this.setListingReportId(listingReport.getId());
		this.setter("listingReport", listingReport);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public ListingReportSubscription setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	@Override
	public ListingReportSubscription save() {
		saveHelper(Url.LISTING_REPORT_SUBSCRIPTIONS);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"listingReportId",
			"subscriberId"
		);
	}
	
}