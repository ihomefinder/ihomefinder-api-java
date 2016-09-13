package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Resources;

public class ListingReportSubscriptions extends Resources<ListingReportSubscription> {

	public ListingReportSubscriptions(Authentication auth) {
		super(auth);
	}
	
}