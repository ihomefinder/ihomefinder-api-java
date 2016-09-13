package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.Savable;
import com.ihomefinder.api.Url;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class OpenHomeReportSubscription extends Resource implements Savable<OpenHomeReportSubscription> {
	
	public OpenHomeReportSubscription(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public OpenHomeReportSubscription setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getOpenHomeReportId() {
		return this.getter("openHomeReportId", Integer.class);
	}
	
	public OpenHomeReportSubscription setOpenHomeReportId(Integer openHomeReportId) {
		this.setter("openHomeReportId", openHomeReportId);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public OpenHomeReportSubscription setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public OpenHomeReport getOpenHomeReport() {
		return this.getter("openHomeReport", OpenHomeReport.class);
	}
	
	public OpenHomeReportSubscription setOpenHomeReport(OpenHomeReport openHomeReport) {
		if(openHomeReport.isTransient()) {
			throw new UnsavedResourceException(openHomeReport);
		}
		this.setOpenHomeReportId(openHomeReport.getId());
		this.setter("openHomeReport", openHomeReport);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public OpenHomeReportSubscription setSubscriber(Subscriber subscriber) {
		if(subscriber.isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	@Override
	public OpenHomeReportSubscription save() {
		saveHelper(Url.OPEN_HOME_REPORT_SUBSCRIPTIONS);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"openHomeReportId",
			"subscriberId"
		);
	}
	
}