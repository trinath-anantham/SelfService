package com.selfservice.dto;

public class RequestMap {

	private String key;
	private Object value;
	private String relation;

	public String getKey() {
		return this.key;
	}

	public void setKey(String argKey) {
		this.key = argKey;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object argValue) {
		this.value = argValue;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String argRelation) {
		this.relation = argRelation;
	}

}
