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
			init(getUrl());
		}
		Object value = getHydratedField(name);
		if(!class_.isInstance(value)) {
			value = ResourceManager.getInstance().getOrCreateInstance(auth, class_, value);
			setHydratedField(name, value);
		}
		return (T) value;
	}
	
	protected void setter(String name, Object value) {
		if(getHydratedField(name) == null || (getHydratedField(name) != null && !getHydratedField(name).equals(value))) {
			addDirtyField(name);
			setHydratedField(name, value);
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
			if(getFieldNames() != null) {
				for(String name : getFieldNames()) {
					if(!isDirtyField(name)) {
						if(!data.containsKey(name)) {
							setHydratedField(name, null);
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
				if(!isDirtyField(name)) {
					setHydratedField(name, value);
				}
			}
		}
	}
	
	private Set<String> getDirtyFields() {
		return dirtyFields;
	}
	
	private boolean hasDirtyFields() {
		return !dirtyFields.isEmpty();
	}
	
	private void addDirtyField(String name) {
		dirtyFields.add(name);
	}
	
	private boolean isDirtyField(String name) {
		return dirtyFields.contains(name);
	}
	
	private Map<String, Object> getDirtyFieldsValues() {
		Map<String, Object> results = new HashMap<>();
		Set<String> names = this.getDirtyFields();
		for(String name : names) {
			Object value = this.getHydratedField(name);
			results.put(name, value);
		}
		return results;
	}
	
	private Set<String> getHydratedFields() {
		return hydratedFields.keySet();
	}
	
	private void setHydratedField(String name, Object value) {
		this.hydratedFields.put(name, value);
	}
	
	private Object getHydratedField(String name) {
		Object result = null;
		if(this.isHydratedField(name)) {
			result = this.hydratedFields.get(name);
		}
		return result;
	}
	
	private boolean isHydratedField(String name) {
		return getHydratedFields().contains(name);
	}
	
	protected Map<String, Object> getHydratedFieldsValues() {
		Map<String, Object> results = new HashMap<>();
		Set<String> names = this.getHydratedFields();
		for(String name : names) {
			Object value = this.getHydratedField(name);
			results.put(name, value);
		}
		return results;
	}
	
	private List<Map<String, Object>> getLinks() {
		return (List<Map<String, Object>>) this.getHydratedField("links");
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
		return getUrl() == null;
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
				.equal(this.getDirtyFieldsValues())
			;
			Map<String, Object> object = new HttpRequest(auth)
				.setUrl(url)
				.setMethod(method)
				.addQuery(query)
				.getResponse()
				.getData()
			;
			hydrate(object);
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