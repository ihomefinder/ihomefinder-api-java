package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class ListingReportSignupRequests extends Resources<ListingReportSignupRequest> {

	public static ListingReportSignupRequests get(Authentication auth, Query query) {
		ListingReportSignupRequests listingReportSignupRequests = new ListingReportSignupRequests(auth);
		listingReportSignupRequests.init(Url.LISTING_REPORT_SIGNUP_REQUESTS, query);
		return listingReportSignupRequests;
	}
	
	public ListingReportSignupRequests(Authentication auth) {
		super(auth);
	}
	
}