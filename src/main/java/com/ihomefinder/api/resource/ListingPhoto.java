package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;
import com.ihomefinder.api.exception.UnsavedResourceException;

public class ListingPhoto extends Resource {
	
	public ListingPhoto(Authentication auth) {
		super(auth);
	}

	public String getId() {
		return this.getter("id", String.class);
	}
	
	public ListingPhoto setId(String id) {
		this.setter("id", id);
		return this;
	}
	
	public String getListingId() {
		return this.getter("listingId", String.class);
	}
	
	public ListingPhoto setListingId(String listingId) {
		this.setter("listingId", listingId);
		return this;
	}
	
	public String getLargeImageUrl() {
		return this.getter("largeImageUrl", String.class);
	}
	
	public ListingPhoto setLargeImageUrl(String largeImageUrl) {
		this.setter("largeImageUrl", largeImageUrl);
		return this;
	}
	
	public String getSmallImageUrl() {
		return this.getter("smallImageUrl", String.class);
	}
	
	public ListingPhoto setSmallImageUrl(String smallImageUrl) {
		this.setter("smallImageUrl", smallImageUrl);
		return this;
	}
	
	public Integer getDisplayOrder() {
		return this.getter("displayOrder", Integer.class);
	}
	
	public ListingPhoto setDisplayOrder(Integer displayOrder) {
		this.setter("displayOrder", displayOrder);
		return this;
	}
	
	public Listing getListing() {
		return this.getter("listing", Listing.class);
	}
	
	public ListingPhoto setListing(Listing listing) {
		if(listing.isTransient()) {
			throw new UnsavedResourceException(listing);
		}
		this.setListingId(listing.getId());
		this.setter("listing", listing);
		return this;
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"listingId",
			"largeImageUrl",
			"smallImageUrl",
			"displayOrder"
		);
	}
	
}