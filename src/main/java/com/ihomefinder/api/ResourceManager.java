package com.ihomefinder.api;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResourceManager {
	
	private static ResourceManager INSTANCE = new ResourceManager();
	private List<Resource> resources = new ArrayList<>();
	
	private ResourceManager() {
		
	}
	
	public static ResourceManager getInstance() {
		return INSTANCE;
	}
	
	public void addResource(Resource resource) {
		this.resources.add(resource);
	}
	
	public Resource getPersistedResource(String href) {
		Resource result = null;
		if(href != null && !href.isEmpty()) {
			for(Resource resource : resources) {
				if(href.equals(resource.getUrl())) {
					result = resource;
				}
			}
		}
		return result;
	}
	
	public <T> T getOrCreateInstance(Authentication auth, Class<T> class_, Object value) {
		T result = null;
		if(value == null) {
			
		} else if(String.class.equals(class_)) {
			result = (T) value;
		} else if(Integer.class.equals(class_)) {
			result = (T) value;
		} else if(Boolean.class.equals(class_)) {
			result = (T) value;
		} else if(Resource.class.isAssignableFrom(class_)) {
			Resource resource = null;
			Map<String, Object> data = (Map<String, Object>) value;
			String href = getHref(data);
			resource = this.getPersistedResource(href);
			if(resource == null) {
				resource = createResource((Class<Resource>) class_, auth);
			}
			resource.hydrate(data);
			result = (T) resource;
		}
		return result;
	}
	
	private String getHref(Map<String, Object> data) {
		String href = null;
		List<Map<String, Object>> links = (List<Map<String, Object>>) data.get("links");
		for(Map<String, Object> link : links) {
			if("self".equals(link.get("rel"))) {
				href = (String) link.get("href");
				break;
			}
		}
		return href;
	}
	
	private <T extends Resource> T createResource(Class<T> class_, Authentication auth) {
		T result = null;
		try {
			Constructor<T> constructor = class_.getConstructor(Authentication.class);
			result = constructor.newInstance(auth);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
}