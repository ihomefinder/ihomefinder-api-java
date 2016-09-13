package com.ihomefinder.api;


public interface Savable<T extends Resource> {
	
	public T save();
	
}
