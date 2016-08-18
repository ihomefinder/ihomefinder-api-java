package com.ihomefinder.api;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ihomefinder.api.exception.ApiException;

public class Resources<E extends Resource> extends Resource implements Collection<E> {
	
	private Class<E> elementClass;
	private ArrayList<E> results = new ArrayList<>();
	private Query query;
	private boolean initialized;
	
	public Resources() {
		super();
		this.elementClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected Class<E> getElementClass() {
		return this.elementClass;
	}
	
	@Override
	public boolean add(E e) {
		return results.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E e : c) {
			add(e);
		}
		return true;
	}

	@Override
	public void clear() {
		removeAll(this);
	}

	@Override
	public boolean contains(Object o) {
		if(!getElementClass().isInstance(o)) {
			
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean result = true;
		for(Object e : c) {
			if(!contains(e)) {
				result = false;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		initialize();
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Override
	public boolean remove(Object o) {
		boolean result = false;
		while(result) {
			result = results.remove(o);
			if(!result) {
				if(initialized) {
					break;
				} else {
					initialize();
				}
			}
		}
		return result;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result = false;
		for(Object e : c) {
			if(remove(c)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return getter("total", Integer.class);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void initialize() {
		if(!this.initialized) {
			this.initialized = true;
			String href = this.wrapper.getHref();
			Map<String, Object> object = new Request()
				.setUrl(href)
				.setMethod("GET")
				.addQuery(this.query)
				.getResponse()
				.getData()
			;
			this.wrapper.hydrate(object);
			List<Map<String, Object>> results = this.getter("results", ArrayList.class);
			if(results != null) {
				for(Map<String, Object> result : results) {
					E resource = ResourceManager.getInstance().load(this.getElementClass(), result);
					this.results.add(resource);
				}
			}
		}
	}
	
	private void create(Resource resource) {
		ResourceWrapper wrapper = ResourceWrapper.getInstance(resource);
		if(wrapper.isTransient()) {
			String url = this.wrapper.getHref();
			Query query = new Query()
				.select(wrapper.getDirtyFields())
				.equal(wrapper.getDirtyFieldsValues())
			;
			Map<String, Object> object = new Request()
				.setUrl(url)
				.setMethod("POST")
				.addQuery(query)
				.getResponse()
				.getData()
			;
			wrapper.hydrate(object);
		} else if(wrapper.hasDirtyFields()) {
		
		}
	}
	
	public Resources<E> query(Query query) {
		if(this.initialized) {
			throw new ApiException("Cannot change query after object is accessed");
		}
		this.query = query;
		return this;
	}
	
	@Override
	protected String[] getFieldNames() {
		return new String[] {
			"results",
		};
	}

	@Override
	public String toString() {
		this.initialize();
		Map<String, Object> result = new HashMap<>();
		result.put("results", results);
		result.put("results", results);
		result.put("results", results);
		return result.toString();
	}
	
}