package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class ContactRequests extends Resources<ContactRequest> {

	public static ContactRequests get(Authentication auth, Query query) {
		ContactRequests contactRequests = new ContactRequests(auth);
		contactRequests.init(Url.CONTACT_REQUESTS, query);
		return contactRequests;
	}
	
	public ContactRequests(Authentication auth) {
		super(auth);
	}
	
}