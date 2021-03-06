package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class MarketReport extends Resource {
	
	public MarketReport(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public MarketReport setId(String id) {
		this.setter("id", id);
		return this;
	}
	
	public Integer getMarketId() {
		return this.getter("marketId", Integer.class);
	}
	
	public MarketReport setMarketId(Integer marketId) {
		this.setter("marketId", marketId);
		return this;
	}
	
	public String getWebPageIntroText() {
		return this.getter("webPageIntroText", String.class);
	}
	
	public MarketReport setWebPageIntroText(String webPageIntroText) {
		this.setter("webPageIntroText", webPageIntroText);
		return this;
	}
	
	public String getEmailIntroText() {
		return this.getter("emailIntroText", String.class);
	}
	
	public MarketReport setEmailIntroText(String emailIntroText) {
		this.setter("emailIntroText", emailIntroText);
		return this;
	}
	
	public Boolean getDisplayInNavigation() {
		return this.getter("displayInNavigation", Boolean.class);
	}
	
	public MarketReport setDisplayInNavigation(Boolean displayInNavigation) {
		this.setter("displayInNavigation", displayInNavigation);
		return this;
	}
	
	public Market getMarket() {
		return this.getter("market", Market.class);
	}
	
	public MarketReportSubscriptions getMarketReportSubscriptions() {
		return this.getter("marketReportSubscriptions", MarketReportSubscriptions.class);
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"marketId",
			"webPageIntroText",
			"emailIntroText",
			"displayInNavigation"
		);
	}
	
}