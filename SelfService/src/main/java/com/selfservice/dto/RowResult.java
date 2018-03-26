package com.selfservice.dto;

public class RowResult {

	private String tenantId;
	private String tenantName;
	private String groovyFileName;
	private String integrationType;
	private long startTime;
	private long endTime;
	private String name;
	private int success;
	private int failure;
	private int skip;
	private String fileName;

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String argTenantId) {
		this.tenantId = argTenantId;
	}

	public String getTenantName() {
		return this.tenantName;
	}

	public void setTenantName(String argTenantName) {
		this.tenantName = argTenantName;
	}

	public String getGroovyFileName() {
		return this.groovyFileName;
	}

	public void setGroovyFileName(String argGroovyFileName) {
		this.groovyFileName = argGroovyFileName;
	}

	public String getIntegrationType() {
		return this.integrationType;
	}

	public void setIntegrationType(String argIntegrationType) {
		this.integrationType = argIntegrationType;
	}

	public long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(long argStartTime) {
		this.startTime = argStartTime;
	}

	public long getEndTime() {
		return this.endTime;
	}

	public void setEndTime(long argEndTime) {
		this.endTime = argEndTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

	public int getSuccess() {
		return this.success;
	}

	public void setSuccess(int argSuccess) {
		this.success = argSuccess;
	}

	public int getFailure() {
		return this.failure;
	}

	public void setFailure(int argFailure) {
		this.failure = argFailure;
	}

	public int getSkip() {
		return this.skip;
	}

	public void setSkip(int argSkip) {
		this.skip = argSkip;
	}

	@Override
	public String toString() {
		return "tenantId : " + this.tenantId + " , tenantName : " + this.tenantName + ", groovyFileName : "
				+ this.groovyFileName+", fileName : "+this.fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String argFileName) {
		this.fileName = argFileName;
	}


}
