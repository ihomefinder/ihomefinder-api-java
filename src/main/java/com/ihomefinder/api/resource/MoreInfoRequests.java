package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class MoreInfoRequests extends Resources<MoreInfoRequest> {
	
	public static MoreInfoRequests get(Authentication auth, Query query) {
		MoreInfoRequests moreInfoRequests = new MoreInfoRequests(auth);
		moreInfoRequests.init(Url.MORE_INFO_REQUESTS, query);
		return moreInfoRequests;
	}
	
	public MoreInfoRequests(Authentication auth) {
		super(auth);
	}
	
}