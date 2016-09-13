package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class MarketReportSignupRequests extends Resources<MarketReportSignupRequest> {

	public static MarketReportSignupRequests get(Authentication auth, Query query) {
		MarketReportSignupRequests marketReportSignupRequests = new MarketReportSignupRequests(auth);
		marketReportSignupRequests.init(Url.MARKET_REPORT_SIGNUP_REQUESTS, query);
		return marketReportSignupRequests;
	}
	
	public MarketReportSignupRequests(Authentication auth) {
		super(auth);
	}
	
}