package com.ihomefinder.api.resource;

import java.util.Date;

import com.ihomefinder.api.Resource;
import com.ihomefinder.api.ResourceWrapper;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class OpenHomeReportSignupRequest extends Resource {
	
	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public OpenHomeReportSignupRequest setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getSubscriberId() {
		return this.getter("subscriberId", Integer.class);
	}
	
	public OpenHomeReportSignupRequest setSubscriberId(Integer subscriberId) {
		this.setter("subscriberId", subscriberId);
		return this;
	}
	
	public Integer getOpenHomeReportId() {
		return this.getter("openHomeReportId", Integer.class);
	}
	
	public OpenHomeReportSignupRequest setOpenHomeReportId(Integer openHomeReportId) {
		this.setter("openHomeReportId", openHomeReportId);
		return this;
	}
	
	public Date getCreatedOn() {
		return this.getter("createdOn", Date.class);
	}
	
	public OpenHomeReportSignupRequest setCreatedOn(Date createdOn) {
		this.setter("createdOn", createdOn);
		return this;
	}
	
	public Subscriber getSubscriber() {
		return this.getter("subscriber", Subscriber.class);
	}
	
	public OpenHomeReportSignupRequest setSubscriber(Subscriber subscriber) {
		if(ResourceWrapper.getInstance(subscriber).isTransient()) {
			throw new UnsavedResourceException(subscriber);
		}
		this.setSubscriberId(subscriber.getId());
		this.setter("subscriber", subscriber);
		return this;
	}
	
	public OpenHomeReport getOpenHomeReport() {
		return this.getter("openHomeReport", OpenHomeReport.class);
	}
	
	public OpenHomeReportSignupRequest setOpenHomeReport(OpenHomeReport openHomeReport) {
		if(ResourceWrapper.getInstance(openHomeReport).isTransient()) {
			throw new UnsavedResourceException(openHomeReport);
		}
		this.setOpenHomeReportId(openHomeReport.getId());
		this.setter("openHomeReport", openHomeReport);
		return this;
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"id",
			"subscriberId",
			"openHomeReportId",
			"createdOn",
			"message",
		};
	}
	
}