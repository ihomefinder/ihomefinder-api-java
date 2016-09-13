package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class Client extends Resource {
	
	public Client(Authentication auth) {
		super(auth);
	}

	public Integer getId() {
		return this.getter("id", Integer.class);
	}
	
	public Client setId(Integer id) {
		this.setter("id", id);
		return this;
	}
	
	public String getFirstName() {
		return this.getter("firstName", String.class);
	}
	
	public Client setFirstName(String firstName) {
		this.setter("firstName", firstName);
		return this;
	}
	
	public String getLastName() {
		return this.getter("lastName", String.class);
	}
	
	public Client setLastName(String lastName) {
		this.setter("lastName", lastName);
		return this;
	}
	
	public Boards getBoards() {
		return this.getter("boards", Boards.class);
	}
	
	public Listings getListings() {
		return this.getter("listings", Listings.class);
	}
	
	public Subscribers getSubscribers() {
		return this.getter("subscribers", Subscribers.class);
	}
	
	public Markets getMarkets() {
		return this.getter("markets", Markets.class);
	}
	
	public Agents getAgents() {
		return this.getter("agents", Agents.class);
	}
	
	public Offices getOffices() {
		return this.getter("offices", Offices.class);
	}
	
	public MoreInfoRequests getMoreInfoRequests() {
		return this.getter("moreInfoRequests", MoreInfoRequests.class);
	}
	
	public ScheduleShowingRequests getScheduleShowingRequests() {
		return this.getter("scheduleShowingRequests", ScheduleShowingRequests.class);
	}
	
	public ValuationRequests getValuationRequests() {
		return this.getter("valuationRequests", ValuationRequests.class);
	}
	
	public ContactRequests getContactRequests() {
		return this.getter("contactRequests", ContactRequests.class);
	}
	
	public ListingReportSignupRequests getListingReportSignupRequests() {
		return this.getter("listingReportSignupRequests", ListingReportSignupRequests.class);
	}
	
	public OpenHomeReportSignupRequests getOpenHomeReportSignupRequests() {
		return this.getter("openHomeReportSignupRequests", OpenHomeReportSignupRequests.class);
	}
	
	public MarketReportSignupRequests getMarketReportSignupRequests() {
		return this.getter("marketReportSignupRequests", MarketReportSignupRequests.class);
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"firstName",
			"lastName"
		);
	}
	
}