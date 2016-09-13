package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class Market extends Resource {
	
	public Market(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public Market setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getClientId() {
		return this.getter("clientId", Integer.class);
	}
	
	public Market setClientId(Integer clientId) {
		this.setter("clientId", clientId);
		return this;
	}
	
	public String getName() {
		return this.getter("name", String.class);
	}
	
	public Market setName(String name) {
		this.setter("name", name);
		return this;
	}
	
	public String getDescription() {
		return this.getter("description", String.class);
	}
	
	public Market setDescription(String description) {
		this.setter("description", description);
		return this;
	}
	
	public Boolean getDisplayOnIndex() {
		return this.getter("displayOnIndex", Boolean.class);
	}
	
	public Market setDisplayOnIndex(Boolean displayOnIndex) {
		this.setter("displayOnIndex", displayOnIndex);
		return this;
	}
	
	public Integer getIndexDisplayOrder() {
		return this.getter("indexDisplayOrder", Integer.class);
	}
	
	public Market setIndexDisplayOrder(Integer indexDisplayOrder) {
		this.setter("indexDisplayOrder", indexDisplayOrder);
		return this;
	}
	
	public ListingReport getListingReport() {
		return this.getter("listingReport", ListingReport.class);
	}
	
	public OpenHomeReport getOpenHomeReport() {
		return this.getter("openHomeReport", OpenHomeReport.class);
	}
	
	public MarketReport getMarketReport() {
		return this.getter("marketReport", MarketReport.class);
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"clientId",
			"name",
			"description",
			"displayOnIndex",
			"indexDisplayOrder"
		);
	}
	
}