package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.Savable;
import com.ihomefinder.api.Url;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class MarketReportSubscription extends Resource implements Savable<MarketReportSubscription> {
	
	public MarketReportSubscription(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public MarketReportSubscription setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getMarketReportId() {
		return this.getter("marketReportId", Integer.class);
	}
	
	public MarketReportSubscription setMarketReportId(Integer marketReportId) {
		this.setter("marketReportId", marketReportId);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public MarketReportSubscription setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public MarketReport getMarketReport() {
		return this.getter("marketReport", MarketReport.class);
	}
	
	public MarketReportSubscription setMarketReport(MarketReport marketReport) {
		if(marketReport.isTransient()) {
			throw new UnsavedResourceException(marketReport);
		}
		this.setMarketReportId(marketReport.getId());
		this.setter("marketReport", marketReport);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public MarketReportSubscription setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	@Override
	public MarketReportSubscription save() {
		saveHelper(Url.MARKET_REPORT_SUBSCRIPTIONS);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"marketReportId",
			"subscriberId"
		);
	}
	
}