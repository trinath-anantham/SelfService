package com.selfservice.dto;

public class FileBasedStatistics {

	private String inputFileName;
	private int successCount;
	private int failureCount;
	private int skipCount;
	private int totalEmailSent;

	public String getInputFileName() {
		return inputFileName;
	}

	public FileBasedStatistics setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
		return this;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public FileBasedStatistics setSuccessCount(int successCount) {
		this.successCount = successCount;
		return this;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public FileBasedStatistics setFailureCount(int failureCount) {
		this.failureCount = failureCount;
		return this;
	}

	public int getSkipCount() {
		return skipCount;
	}

	public FileBasedStatistics setSkipCount(int skipCount) {
		this.skipCount = skipCount;
		return this;
	}
	
	public int getTotalEmailSent() {
		return totalEmailSent;
	}

	public FileBasedStatistics setTotalEmailSent(int totalEmailSent) {
		this.totalEmailSent = totalEmailSent;
		return this;
	}

}
