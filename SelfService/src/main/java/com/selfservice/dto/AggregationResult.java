package com.selfservice.dto;

import java.util.List;

public class AggregationResult {

	private Id _id;
	private List<Statistics> data;

	public Id get_id() {
		return _id;
	}

	public void set_id(Id _id) {
		this._id = _id;
	}

	public List<Statistics> getData() {
		return data;
	}

	public void setData(List<Statistics> data) {
		this.data = data;
	}

}
