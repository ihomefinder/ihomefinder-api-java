package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class OpenHomeReportSignupRequests extends Resources<OpenHomeReportSignupRequest> {

	public static OpenHomeReportSignupRequests get(Authentication auth, Query query) {
		OpenHomeReportSignupRequests openHomeReportSignupRequests = new OpenHomeReportSignupRequests(auth);
		openHomeReportSignupRequests.init(Url.OPEN_HOME_REPORT_SIGNUP_REQUESTS, query);
		return openHomeReportSignupRequests;
	}
	
	public OpenHomeReportSignupRequests(Authentication auth) {
		super(auth);
	}
	
}