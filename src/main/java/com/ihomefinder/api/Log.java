package com.ihomefinder.api;

public class Log {
	
	public static void debug(Object value) {
		if(Constants.DEBUG) {
			System.out.println(value);
		}
	}
	
}
