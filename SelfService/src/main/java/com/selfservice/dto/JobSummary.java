package com.selfservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobSummary")
public class JobSummary {

	@Id
	private String id;
	private String tenantId;
	private String tenantName;
	private String groovyFileName;
	private String integrationType;
	private long startTime;
	private long endTime;
	private String status;
	private boolean fatal;
	private String fatalReason;

	public String getId() {
		return id;
	}

	public JobSummary setId(String id) {
		this.id = id;
		return this;
	}

	public String getTenantId() {
		return tenantId;
	}

	public JobSummary setTenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	public String getTenantName() {
		return tenantName;
	}

	public JobSummary setTenantName(String tenantName) {
		this.tenantName = tenantName;
		return this;
	}

	public String getGroovyFileName() {
		return groovyFileName;
	}

	public JobSummary setGroovyFileName(String groovyFileName) {
		this.groovyFileName = groovyFileName;
		return this;
	}

	public String getIntegrationType() {
		return integrationType;
	}

	public JobSummary setIntegrationType(String integrationType) {
		this.integrationType = integrationType;
		return this;
	}

	public long getStartTime() {
		return startTime;
	}

	public JobSummary setStartTime(long startTime) {
		this.startTime = startTime;
		return this;
	}

	public long getEndTime() {
		return endTime;
	}

	public JobSummary setEndTime(long endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public JobSummary setStatus(String status) {
		this.status = status;
		return this;
	}

	public boolean isFatal() {
		return fatal;
	}

	public JobSummary setFatal(boolean fatal) {
		this.fatal = fatal;
		return this;
	}

	public String getFatalReason() {
		return fatalReason;
	}

	public JobSummary setFatalReason(String fatalReason) {
		this.fatalReason = fatalReason;
		return this;
	}

}
