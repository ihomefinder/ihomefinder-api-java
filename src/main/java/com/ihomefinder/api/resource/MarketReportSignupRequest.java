package com.ihomefinder.api.resource;

import java.util.Date;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class MarketReportSignupRequest extends Resource {
	
	public MarketReportSignupRequest(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public MarketReportSignupRequest setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public MarketReportSignupRequest setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public Integer getMarketReportId() {
		return this.getter("marketReportId", Integer.class);
	}
	
	public MarketReportSignupRequest setMarketReportId(Integer marketReportId) {
		this.setter("marketReportId", marketReportId);
		return this;
	}
	
	public Date getCreatedOn() {
		return this.getter("createdOn", Date.class);
	}
	
	public MarketReportSignupRequest setCreatedOn(Date createdOn) {
		this.setter("createdOn", createdOn);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public MarketReportSignupRequest setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	public MarketReport getMarketReport() {
		return this.getter("marketReport", MarketReport.class);
	}
	
	public MarketReportSignupRequest setMarketReport(MarketReport marketReport) {
		if(marketReport.isTransient()) {
			throw new UnsavedResourceException(marketReport);
		}
		this.setMarketReportId(marketReport.getId());
		this.setter("marketReport", marketReport);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"subscriberId",
			"marketReportId",
			"createdOn"
		);
	}
	
}