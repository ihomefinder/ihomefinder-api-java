package com.ihomefinder.api.resource;

import com.ihomefinder.api.Resource;
import com.ihomefinder.api.ResourceWrapper;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ReportSubscription extends Resource {
	
	public Integer getMarketId() {
		return this.getter("marketId", Integer.class);
	}
	
	public ReportSubscription setMarketId(Integer marketId) {
		this.setter("marketId", marketId);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public ReportSubscription setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public Boolean getListingReportEnabled() {
		return this.getter("listingReportEnabled", Boolean.class);
	}
	
	public ReportSubscription setListingReportEnabled(Boolean listingReportEnabled) {
		this.setter("listingReportEnabled", listingReportEnabled);
		return this;
	}
	
	public Boolean getOpenHomeReportEnabled() {
		return this.getter("openHomeReportEnabled", Boolean.class);
	}
	
	public ReportSubscription setOpenHomeReportEnabled(Boolean openHomeReportEnabled) {
		this.setter("openHomeReportEnabled", openHomeReportEnabled);
		return this;
	}
	
	public Boolean getMarketReportEnabled() {
		return this.getter("marketReportEnabled", Boolean.class);
	}
	
	public ReportSubscription setMarketReportEnabled(Boolean marketReportEnabled) {
		this.setter("marketReportEnabled", marketReportEnabled);
		return this;
	}
	
	public Market getMarket() {
		return this.getter("market", Market.class);
	}
	
	public ReportSubscription setMarket(Market market) {
		if(ResourceWrapper.getInstance(market).isTransient()) {
			throw new UnsavedResourceException(market);
		}
		this.setMarketId(market.getId());
		this.setter("market", market);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public ReportSubscription setSubscriber(Subscriber subscriber) {
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
			"marketId",
			"subscriberId",
			"listingReportEnabled",
			"openHomeReportEnabled",
			"marketReportEnabled",
		};
	}
	
}