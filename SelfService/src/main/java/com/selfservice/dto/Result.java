package com.selfservice.dto;

import java.util.List;

public class Result {

	private String _id;
	private List<RowResult> values;
	private List<String> headers;

	public String get_id() {
		return this._id;
	}

	public void set_id(String arg_id) {
		this._id = arg_id;
	}

	public List<RowResult> getValues() {
		return this.values;
	}

	public void setValues(List<RowResult> argValues) {
		this.values = argValues;
	}

	public List<String> getHeaders() {
		return this.headers;
	}

	public void setHeaders(List<String> argHeaders) {
		this.headers = argHeaders;
	}
	
	@Override
	public String toString() {
		return "id: "+this._id+" values - "+this.values;
	}

}
