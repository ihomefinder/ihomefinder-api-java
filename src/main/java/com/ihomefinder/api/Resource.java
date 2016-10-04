package com.ihomefinder.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Resource {
	
	protected final Authentication auth;
	private Map<String, Object> hydratedFields = new HashMap<>();
	private Set<String> dirtyFields = new HashSet<>();
	
	protected abstract Collection<String> getFieldNames();
	
	public Resource(Authentication auth) {
		this.auth = auth;
		ResourceManager.getInstance().addResource(this);
	}

	protected <T> T getter(String name, Class<T> class_) {
		if(!isHydratedField(name)) {
			this.init(getUrl());
		}
		Object value = getHydratedFieldValue(name);
		if(!class_.isInstance(value)) {
			value = ResourceManager.getInstance().getOrCreateInstance(auth, class_, value);
			this.setHydratedField(name, value);
		}
		return (T) value;
	}
	
	protected void setter(String name, Object value) {
		if(this.getHydratedFieldValue(name) == null || (this.getHydratedFieldValue(name) != null && !this.getHydratedFieldValue(name).equals(value))) {
			this.addDirtyField(name);
			this.setHydratedField(name, value);
		}
	}
	
	protected void init(String url) {
		if(url != null) {
			Map<String, Object> data = new HttpRequest(auth)
				.setUrl(url)
				.setMethod("GET")
				.getResponse()
				.getData()
			;
			hydrate(data);
			//Hydrate known fields with null. This prevents repeated attempts to hydrate object.
			if(this.getFieldNames() != null) {
				for(String name : this.getFieldNames()) {
					if(!this.isDirtyField(name)) {
						if(!data.containsKey(name)) {
							this.setHydratedField(name, null);
						}
					}
				}
			}
		}
	}
	
	protected void hydrate(Map<String, Object> data) {
		if(data != null) {
			for(Entry<String, Object> entry : data.entrySet()) {
				String name = entry.getKey();
				Object value = entry.getValue();
				if(!this.isDirtyField(name)) {
					this.setHydratedField(name, value);
				}
			}
		}
	}
	
	private Set<String> getDirtyFields() {
		return this.dirtyFields;
	}
	
	private boolean hasDirtyFields() {
		return !this.dirtyFields.isEmpty();
	}
	
	private void addDirtyField(String name) {
		this.dirtyFields.add(name);
	}
	
	private boolean isDirtyField(String name) {
		return this.dirtyFields.contains(name);
	}
	
	private Map<String, Object> getDirtyFieldsValues() {
		Map<String, Object> results = new HashMap<>();
		Set<String> names = this.getDirtyFields();
		for(String name : names) {
			Object value = this.getHydratedFieldValue(name);
			results.put(name, value);
		}
		return results;
	}
	
	protected Map<String, Object> getHydratedFields() {
		return this.hydratedFields;
	}
	
	private void setHydratedField(String name, Object value) {
		this.hydratedFields.put(name, value);
	}
	
	private Object getHydratedFieldValue(String name) {
		Object result = null;
		if(this.isHydratedField(name)) {
			result = this.hydratedFields.get(name);
		}
		return result;
	}
	
	private boolean isHydratedField(String name) {
		return this.getHydratedFields().containsKey(name);
	}
	
	private List<Map<String, Object>> getLinks() {
		return (List<Map<String, Object>>) this.getHydratedFieldValue("links");
	}
	
	protected String getUrl() {
		String result = null;
		List<Map<String, Object>> links = this.getLinks();
		if(links != null) {
			for(Map<String, Object> link : links) {
				if("self".equals(link.get("rel"))) {
					result = (String) link.get("href");
					break;
				}
			}
		}
		return result;
	}
	
	public boolean isTransient() {
		return this.getUrl() == null;
	}
	
	protected void saveHelper(String createUrl) {
		if(hasDirtyFields()) {
			String url = null;
			String method = null;
			if(isTransient()) {
				url = createUrl;
				method = "POST";
			} else {
				url = this.getUrl();
				method = "PUT";
			}
			Query query = new Query()
				.select(this.getDirtyFields())
				.whereAll(this.getDirtyFieldsValues())
			;
			Map<String, Object> object = new HttpRequest(auth)
				.setUrl(url)
				.setMethod(method)
				.addQuery(query)
				.getResponse()
				.getData()
			;
			this.hydrate(object);
		}
	}
//	
//	public void delete() {
//		String url = this.getUrl();
//		new HttpRequest(auth)
//			.setUrl(url)
//			.setMethod("DELETE")
//			.getResponse()
//			.getData()
//		;
//	}
	
}