package com.ihomefinder.api.resource;

import com.ihomefinder.api.Resource;

public class ListingReport extends Resource {
	
	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public ListingReport setId(String id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getMarketId() {
		return this.getter("marketId", Integer.class);
	}
	
	public ListingReport setMarketId(Integer marketId) {
		this.setter("marketId", marketId);
		return this;
	}
	
	public String getWebPageIntroText() {
		return this.getter("webPageIntroText", String.class);
	}
	
	public ListingReport setWebPageIntroText(String webPageIntroText) {
		this.setter("webPageIntroText", webPageIntroText);
		return this;
	}
	
	public String getEmailIntroText() {
		return this.getter("emailIntroText", String.class);
	}
	
	public ListingReport setEmailIntroText(String emailIntroText) {
		this.setter("emailIntroText", emailIntroText);
		return this;
	}
	
	public Boolean getDisplayInNavigation() {
		return this.getter("displayInNavigation", Boolean.class);
	}
	
	public ListingReport setDisplayInNavigation(Boolean displayInNavigation) {
		this.setter("displayInNavigation", displayInNavigation);
		return this;
	}
	
	public Market getMarket() {
		return this.getter("market", Market.class);
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"id",
			"marketId",
			"webPageIntroText",
			"emailIntroText",
			"displayInNavigation",
		};
	}
	
}