package com.ihomefinder.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Query implements Cloneable {
	
	protected Set<String> fields = new HashSet<>();
	protected Map<String, Object> where = new HashMap<>();
	protected Integer limit;
	protected Integer offset;
	
	public Query select(String ...fields) {
		this.fields.addAll(Arrays.asList(fields));
		return this;
	}
	
	public Query select(Collection<String> fields) {
		this.fields.addAll(fields);
		return this;
	}
	
	public Query where(String fieldName, Object fieldValue) {
		this.where.put(fieldName, fieldValue);
		return this;
	}
	
	public Query whereAll(Map<String, Object> fields) {
		this.where.putAll(fields);
		return this;
	}
	
	public Query example(Resource resource) {
		Map<String, Object> fields = resource.getHydratedFields();
		whereAll(fields);
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
	
	
	
	public void loadRequest(HttpRequest request) {
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
//	
//	@Override
//	public Query clone() {
//		Query result = new Query();
//		result.fields.addAll(this.fields);
//		result.where.putAll(this.where);
//		result.offset = this.offset;
//		result.limit = this.limit;
//		return result;
//	}
	
}