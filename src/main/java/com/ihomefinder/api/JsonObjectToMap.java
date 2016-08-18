package com.ihomefinder.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

class JsonObjectToMap {
	
	private final Map<String, Object> results;
	
	public JsonObjectToMap(JSONObject jsonObject) {
		this.results = convert(jsonObject);
	}
	
	private Map<String, Object> convert(JSONObject object) {
		Map<String, Object> results = new HashMap<>();
		Set<String> keys = object.keySet();
		for(String key : keys) {
			Object value = object.get(key);
			value = convert(value);
			results.put(key, value);
		}
		return results;
	}
	
	private List<Object> convert(JSONArray array) {
		List<Object> results = new ArrayList<>();
		for(Object value : array) {
			value = convert(value);
			results.add(value);
		}
		return results;
	}
	
	private Object convert(Object value) {
		if(value instanceof JSONObject) {
			value = convert((JSONObject) value);
		} else if(value instanceof JSONArray) {
			value = convert((JSONArray) value);
		}
		return value;
	}

	public Map<String, Object> getResults() {
		return results;
	}
	
}
