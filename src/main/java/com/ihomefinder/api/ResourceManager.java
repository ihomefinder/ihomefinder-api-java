package com.ihomefinder.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ResourceManager {
	
	private List<Resource> resources = new ArrayList<>();
	private Map<String, Resource> persistedResources = new HashMap<>();
	private static ResourceManager instance;
	
	private ResourceManager() {
		
	}
	
	public static ResourceManager getInstance() {
		if(instance == null) {
			instance = new ResourceManager();
		}
		return instance;
	}
	
	public void addResource(Resource resource) {
		this.resources.add(resource);
	}
	
	public void setPersistedResource(String href, Resource resource) {
		this.persistedResources.put(href, resource);
	}
	
	public Resource getPersistedResource(String href) {
		return this.persistedResources.get(href);
	}
	
	public boolean hasPersistedResource(String href) {
		return this.persistedResources.containsKey(href);
	}
	
	public <ValueType> ValueType load(Class<ValueType> class_, Object object) {
		ValueType resource = null;
		if(object == null) {
			
		} else if(String.class.equals(class_)) {
			resource = (ValueType) object;
		} else if(Integer.class.equals(class_)) {
			resource = (ValueType) object;
		} else if(Boolean.class.equals(class_)) {
			resource = (ValueType) object;
		} else if(Resource.class.isAssignableFrom(class_)) {
			Map<String, Object> map = (Map<String, Object>) object;
			Class<? extends Resource> foo = (Class<? extends Resource>) class_;
			resource = (ValueType) load(foo, map);
		}
		return resource;
	}
	
	public <T extends Resource> T load(Class<T> class_, Map<String, Object> map) {
		T resource = null;
		List<Map<String, Object>> links = (List<Map<String, Object>>) map.get("links");
		for(Map<String, Object> link : links) {
			if("self".equals(link.get("rel"))) {
				String href = (String) link.get("href");
				if(this.hasPersistedResource(href)) {
					resource = (T) this.getPersistedResource(href);
				} else {
					try {
						resource = class_.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						throw new RuntimeException(e);
					}
					ResourceWrapper wrapper = ResourceWrapper.getInstance(resource);
					for(Entry<String, Object> entry : map.entrySet()) {
						String name = entry.getKey();
						Object value = entry.getValue();
						if(!wrapper.isHydratedField(name)) {
							wrapper.setHydratedField(name, value);
						}
					}
					wrapper.setTransient(false);
					this.setPersistedResource(href, resource);
				}
				break;
			}
		}
		return resource;
	}
	
	public void save() {
		for(Resource resource : this.resources) {
			ResourceWrapper wrapper = ResourceWrapper.getInstance(resource);
			if(!wrapper.isTransient()) {
				wrapper.save();
			}
		}
	}
	
}