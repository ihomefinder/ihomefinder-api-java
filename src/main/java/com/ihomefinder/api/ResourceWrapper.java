package com.ihomefinder.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResourceWrapper {
	
	private Resource resource;
	private Class<?> class_;
	private ResourceManager manager;
	private Set<String> dirtyFields = new HashSet<>();
	private Map<String, Object> hydratedFields = new HashMap<>();
	private boolean transient_ = true;
	private static Map<Integer, ResourceWrapper> instances = new HashMap<>();
	
	private ResourceWrapper(Resource resource) {
		this.resource = resource;
		this.class_ = resource.getClass();
		this.manager = ResourceManager.getInstance();
		ResourceManager.getInstance().addResource(resource);
	}
	
	public static ResourceWrapper getInstance(Resource resource) {
		ResourceWrapper instance = null;
		Integer key = resource.hashCode();
		if(instances.containsKey(key)) {
			instance = instances.get(key);
		} else {
			instance = new ResourceWrapper(resource);
			instances.put(key, instance);
		}
		return instance;
	}
	
	public boolean isTransient() {
		return this.transient_;
	}
	
	public void setTransient(boolean transient_) {
		this.transient_ = transient_;
	}
	
	public Set<String> getHydratedFields() {
		return hydratedFields.keySet();
	}
	
	public Object getHydratedField(String name) {
		Object result = null;
		if(this.isHydratedField(name)) {
			result = this.hydratedFields.get(name);
		}
		return result;
	}
	
	public void setHydratedField(String name, Object value) {
		this.hydratedFields.put(name, value);
	}
	
	public boolean isHydratedField(String name) {
		return getHydratedFields().contains(name);
	}
	
	public Set<String> getDirtyFields() {
		return dirtyFields;
	}
	
	public Map<String, Object> getDirtyFieldsValues() {
		Map<String, Object> results = new HashMap<>();
		Set<String> names = this.getDirtyFields();
		for(String name : names) {
			Object value = this.getHydratedField(name);
			results.put(name, value);
		}
		return results;
	}
	
	public void addDirtyField(String name) {
		dirtyFields.add(name);
	}
	
	public boolean isDirtyField(String name) {
		return dirtyFields.contains(name);
	}
	
	public boolean hasDirtyFields() {
		return !dirtyFields.isEmpty();
	}
	
	public Map<String, Object> getAllFieldsValues() {
		Map<String, Object> results = new HashMap<>();
		String[] names = this.getFieldNames();
		for(String name : names) {
			if(!this.isHydratedField(name)) {
				this.hydrate(null);
			}
			Object value = this.getHydratedField(name);
			results.put(name, value);
		}
		return results;
	}
	
	public String[] getFieldNames() {
		return resource.getFieldNames();
	}
	
	public List<Map<String, Object>> getLinks() {
		return (List<Map<String, Object>>) this.getHydratedField("links");
	}
	
	public String getHref() {
		String result = null;
		List<Map<String, Object>> links = this.getLinks();
		for(Map<String, Object> link : links) {
			if("self".equals(link.get("rel"))) {
				result = (String) link.get("href");
				break;
			}
		}
		return result;
	}
	
	public void save() {
		resource.save();
	}
	
	public void hydrate(Map<String, Object> object) {
		resource.hydrate(object);
	}
	
}