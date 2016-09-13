package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Query;
import com.ihomefinder.api.Resources;
import com.ihomefinder.api.Url;

public class Agents extends Resources<Agent> {

	public static Agents get(Authentication auth, Query query) {
		Agents agents = new Agents(auth);
		agents.init(Url.AGENTS, query);
		return agents;
	}
	
	public Agents(Authentication auth) {
		super(auth);
	}
	
}