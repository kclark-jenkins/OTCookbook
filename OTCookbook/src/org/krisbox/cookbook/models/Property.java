package org.krisbox.cookbook.models;

import java.util.HashMap;
import java.util.Map;

public class Property {
	private long   id;
	private String key;
	private String value;
	
	public Property() {
	}
	
	public Property(long id, String key, String value){
		this.id  = id;
		this.key = key;
		this.value = value;
	}
	
	public void setId(long id){this.id = id;}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	public long getId(){return id;}
}
