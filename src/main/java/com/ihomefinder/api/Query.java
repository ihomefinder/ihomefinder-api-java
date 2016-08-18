package com.ihomefinder.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Query {
	
	protected Set<String> fields = new HashSet<>();
	protected Map<String, Object> where = new HashMap<>();
	protected Integer offset;
	protected Integer limit;
	
	public Query select(String ...fields) {
		this.fields.addAll(Arrays.asList(fields));
		return this;
	}
	
	public Query select(Collection<String> fields) {
		this.fields.addAll(fields);
		return this;
	}
	
	public Query equal(String fieldName, Object fieldValue) {
		this.where.put(fieldName, fieldValue);
		return this;
	}
	
	public Query equal(Map<String, Object> fields) {
		this.where.putAll(fields);
		return this;
	}
	
	public Query example(Resource resource) {
		ResourceWrapper wrapper = ResourceWrapper.getInstance(resource);
		Map<String, Object> fields = wrapper.getAllFieldsValues();
		for(Entry<String, Object> entry : fields.entrySet()) {
			String fieldName = entry.getKey();
			Object fieldValue = entry.getValue();
			if(fieldValue != null) {
				this.equal(fieldName, fieldValue);
			}

		}
		return this;
	}
	
	public Query limit(Integer limit) {
		this.limit = limit;
		return this;
	}
	
	public Query offset(Integer offset) {
		this.offset = offset;
		return this;
	}
	
	public void loadRequest(Request request) {
		request.setParameters(this.where);
		if(this.offset != null) {
			request.setParameter("offset", this.offset);
		}
		if(this.limit != null) {
			request.setParameter("limit", this.limit);
		}
		if(!this.fields.isEmpty()) {
			request.setParameter("fields", String.join(",", this.fields));
		}
	}
	
}