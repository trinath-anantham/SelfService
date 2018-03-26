package com.selfservice.dto;

import java.util.List;

public class RequestJson {

	private List<RequestMap> restrictionMap;
	private List<String> selectionMap;

	public List<RequestMap> getRestrictionMap() {
		return this.restrictionMap;
	}

	public void setRestrictionMap(List<RequestMap> argRestrictionMap) {
		this.restrictionMap = argRestrictionMap;
	}

	public List<String> getSelectionMap() {
		return this.selectionMap;
	}

	public void setSelectionMap(List<String> argSelectionMap) {
		this.selectionMap = argSelectionMap;
	}

}
