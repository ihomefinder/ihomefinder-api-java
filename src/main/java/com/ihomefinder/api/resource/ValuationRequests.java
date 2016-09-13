package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class ValuationRequests extends Resources<ValuationRequest> {

	public static ValuationRequests get(Authentication auth, Query query) {
		ValuationRequests valuationRequests = new ValuationRequests(auth);
		valuationRequests.init(Url.VALUATION_REQUESTS, query);
		return valuationRequests;
	}
	
	public ValuationRequests(Authentication auth) {
		super(auth);
	}
	
}