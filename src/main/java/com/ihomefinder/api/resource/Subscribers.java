package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class Subscribers extends Resources<Subscriber> {

	public static Subscribers get(Authentication auth, Query query) {
		Subscribers subscribers = new Subscribers(auth);
		subscribers.init(Url.SUBSCRIBERS, query);
		return subscribers;
	}
	
	public Subscribers(Authentication auth) {
		super(auth);
	}
	
}