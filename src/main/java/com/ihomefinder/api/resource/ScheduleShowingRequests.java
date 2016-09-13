package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class ScheduleShowingRequests extends Resources<ScheduleShowingRequest> {

	public static ScheduleShowingRequests get(Authentication auth, Query query) {
		ScheduleShowingRequests scheduleShowingRequests = new ScheduleShowingRequests(auth);
		scheduleShowingRequests.init(Url.SCHEDULE_SHOWING_REQUESTS, query);
		return scheduleShowingRequests;
	}
	
	public ScheduleShowingRequests(Authentication auth) {
		super(auth);
	}
		
}