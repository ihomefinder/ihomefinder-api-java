package com.ihomefinder.api;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class Resources<E extends Resource> extends Resource implements Iterable<E> {
	
	private final Class<E> elementClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	private final ArrayList<E> results = new ArrayList<>();
	
	private Query query = setQueryDefaults(new Query());
	
	public Resources(Authentication auth) {
		super(auth);
	}
	
	protected Class<E> getElementClass() {
		return this.elementClass;
	}

	@Override
	public Iterator<E> iterator() {
		Resources<E> self = this;
		Iterator<E> iterator = new Iterator<E>() {
			
			private int cursor = 0;
			
			@Override
			public boolean hasNext() {
				boolean result = false;
				if(cursor < size()) {
					result = true;
				}
				return result;
			}

			@Override
			public E next() {
				E result = null;
				if(cursor >= results.size() && size() > results.size()) {
					self.query
						.offset(cursor)
					;
					self.init(getUrl(), self.query);
				}
				if(cursor < results.size()) {
					result = results.get(cursor);
				}
				cursor++;
				return result;
			}
		};
		return iterator;
	}

	public int size() {
		Integer result = getter("total", Integer.class);
		if(result == null) {
			result = 0;
		}
		return result;
	}
	
	protected void init(String url, Query query) {
		this.query = setQueryDefaults(query);
		init(url);
	}
	
	@Override
	protected void init(String url) {
		Map<String, Object> object = new HttpRequest(auth)
			.setUrl(url)
			.setMethod("GET")
			.addQuery(query)
			.getResponse()
			.getData()
		;
		this.hydrate(object);
	}
	
	@Override
	protected void hydrate(Map<String, Object> data) {
		super.hydrate(data);
		List<Map<String, Object>> results = (List<Map<String, Object>>) data.get("results");
		if(results != null) {
			for(Map<String, Object> result : results) {
				E resource = ResourceManager.getInstance().getOrCreateInstance(auth, this.getElementClass(), result);
				this.results.add(resource);
			}
		}
	}
	
	private Query setQueryDefaults(Query query) {
		if(query == null) {
			query = new Query();
		}
		query
			.select("*")
			.limit(50)
		;
		return query;
	}
	
	@Override
	protected Fields getFieldNames() {
		return null;
	}
	
}