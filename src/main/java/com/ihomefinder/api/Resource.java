package com.ihomefinder.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ihomefinder.api.exception.ResourceUnavailableException;

public abstract class Resource {
	
	protected ResourceWrapper wrapper;
	
	protected Map<String, Object> requestParameters = new HashMap<>();
	
	protected abstract String[] getFieldNames();
	
	public Resource() {
		this.wrapper = ResourceWrapper.getInstance(this);
	}
	
	protected <T> T getter(String name, Class<T> class_) {
		if(!wrapper.isHydratedField(name)) {
			wrapper.hydrate(null);
		}
		Object value = wrapper.getHydratedField(name);
		if(value == null) {
			throw new ResourceUnavailableException(null);
		}
		if(!class_.isInstance(value)) {
			value = ResourceManager.getInstance().load(class_, value);
			wrapper.setHydratedField(name, value);
		}
		return (T) value;
	}
	
	protected void setter(String name, Object value) {
		if(wrapper.getHydratedField(name) != null && !wrapper.getHydratedField(name).equals(value)) {
			wrapper.addDirtyField(name);
			wrapper.setHydratedField(name, value);
		}
	}
	
	protected void hydrate(Map<String, Object> object) {
		if(object == null) {
			String url = wrapper.getHref();
			if(url != null) {
				object = new Request()
					.setUrl(url)
					.setMethod("GET")
					.setParameters(this.requestParameters)
					.getResponse()
					.getData()
				;
			}
		}
		if(object != null) {
			//Hydrate fields with value from object
			for(Entry<String, Object> entry : object.entrySet()) {
				String name = entry.getKey();
				Object value = entry.getValue();
				if(!wrapper.isDirtyField(name)) {
					wrapper.setHydratedField(name, value);
				}
			}
			//Hydrate remaining known fields with null. This prevents repeated attempts to hydrate object.
			for(String name : this.wrapper.getFieldNames()) {
				if(!wrapper.isDirtyField(name)) {
					if(!object.containsKey(name)) {
						wrapper.setHydratedField(name, null);
					}
				}
			}
			wrapper.setTransient(false);
		}
	}
	
	protected void save() {
		if(wrapper.hasDirtyFields()) {
			String url = this.wrapper.getHref();
			Query query = new Query()
				.select(this.wrapper.getDirtyFields())
				.equal(this.wrapper.getDirtyFieldsValues())
			;
			Map<String, Object> object = new Request()
				.setUrl(url)
				.setMethod("PUT")
				.addQuery(query)
				.getResponse()
				.getData()
			;
			wrapper.hydrate(object);
		}
	}
	
	protected void delete() {
		String url = wrapper.getHref();
		Map<String, Object> object = new Request()
			.setUrl(url)
			.setMethod("DELETE")
			.getResponse()
			.getData()
		;
		wrapper.setTransient(true);
	}
	
	@Override
	public String toString() {
		return this.wrapper.getAllFieldsValues().toString();
	}
	
}