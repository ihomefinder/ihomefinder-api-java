package com.ihomefinder.api.resource;

import com.ihomefinder.api.Authentication;
import com.ihomefinder.api.Fields;
import com.ihomefinder.api.Resource;

public class Listing extends Resource {
	
	public Listing(Authentication auth) {
		super(auth);
	}

	public String getId() {
		return this.getter("id", String.class);
	}
	
	public Listing setId(String id) {
		this.setter("id", id);
		return this;
	}
	
	public String getListingNumber() {
		return this.getter("listingNumber", String.class);
	}
	
	public Listing setListingNumber(String listingNumber) {
		this.setter("listingNumber", listingNumber);
		return this;
	}
	
	public String getBoardId() {
		return this.getter("boardId", String.class);
	}
	
	public Listing setBoardId(String boardId) {
		this.setter("boardId", boardId);
		return this;
	}
	
	public ListingAddress getAddress() {
		return this.getter("address", ListingAddress.class);
	}
	
	public Listing setAddress(ListingAddress address) {
		this.setter("address", address);
		return this;
	}
	
	public String getBedrooms() {
		return this.getter("bedrooms", String.class);
	}
	
	public Listing setBedrooms(String bedrooms) {
		this.setter("bedrooms", bedrooms);
		return this;
	}
	
	public String getFullBathrooms() {
		return this.getter("fullBathrooms", String.class);
	}
	
	public Listing setFullBathrooms(String fullBathrooms) {
		this.setter("fullBathrooms", fullBathrooms);
		return this;
	}
	
	public String getPartialBathrooms() {
		return this.getter("partialBathrooms", String.class);
	}
	
	public Listing setPartialBathrooms(String partialBathrooms) {
		this.setter("partialBathrooms", partialBathrooms);
		return this;
	}
	
	public Board getBoard() {
		return this.getter("board", Board.class);
	}
	
	public ListingPhotos getPhotos() {
		return this.getter("photos", ListingPhotos.class);
	}
	
	@Override
	protected Fields getFieldNames() {
		return new Fields(
			"id",
			"listingNumber",
			"boardId",
			"bedrooms",
			"fullBathrooms",
			"partialBathrooms"
		);
	}
	
}