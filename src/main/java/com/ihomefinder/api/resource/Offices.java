package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class Offices extends Resources<Office> {

	public static Offices get(Authentication auth, Query query) {
		Offices offices = new Offices(auth);
		offices.init(Url.OFFICES, query);
		return offices;
	}
	
	public Offices(Authentication auth) {
		super(auth);
	}
	
}