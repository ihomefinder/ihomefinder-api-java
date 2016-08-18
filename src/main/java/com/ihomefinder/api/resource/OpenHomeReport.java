package com.ihomefinder.api.resource;

import com.ihomefinder.api.Resource;

public class OpenHomeReport extends Resource {
	
	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public OpenHomeReport setId(String id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getMarketId() {
		return this.getter("marketId", Integer.class);
	}
	
	public OpenHomeReport setMarketId(Integer marketId) {
		this.setter("marketId", marketId);
		return this;
	}
	
	public String getWebPageIntroText() {
		return this.getter("webPageIntroText", String.class);
	}
	
	public OpenHomeReport setWebPageIntroText(String webPageIntroText) {
		this.setter("webPageIntroText", webPageIntroText);
		return this;
	}
	
	public String getEmailIntroText() {
		return this.getter("emailIntroText", String.class);
	}
	
	public OpenHomeReport setEmailIntroText(String emailIntroText) {
		this.setter("emailIntroText", emailIntroText);
		return this;
	}
	
	public Boolean getDisplayInNavigation() {
		return this.getter("displayInNavigation", Boolean.class);
	}
	
	public OpenHomeReport setDisplayInNavigation(Boolean displayInNavigation) {
		this.setter("displayInNavigation", displayInNavigation);
		return this;
	}
	
	public Boolean getLimitEmailToFeaturedListings() {
		return this.getter("limitEmailToFeaturedListings", Boolean.class);
	}
	
	public OpenHomeReport setLimitEmailToFeaturedListings(Boolean limitEmailToFeaturedListings) {
		this.setter("limitEmailToFeaturedListings", limitEmailToFeaturedListings);
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
			"limitEmailToFeaturedListings",
		};
	}
	
}