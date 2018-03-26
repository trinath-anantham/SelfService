package com.selfservice.dto;

import java.util.List;

public class FailureStatistics {

	private List<String> failures;
	private String fileName;

	public List<String> getFailures() {
		return failures;
	}

	public FailureStatistics setFailures(List<String> failures) {
		this.failures = failures;
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public FailureStatistics setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}
}
