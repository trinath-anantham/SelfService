package com.selfservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "failureReason")
public class FailureReason {

	@Id
	private String id;
	private String jobId;
	private String stageId;
	private List<FailureStatistics> failureStatisticsList;

	public String getId() {
		return id;
	}

	public FailureReason setId(String id) {
		this.id = id;
		return this;
	}

	public String getJobId() {
		return jobId;
	}

	public FailureReason setJobId(String jobId) {
		this.jobId = jobId;
		return this;
	}

	public String getStageId() {
		return stageId;
	}

	public FailureReason setStageId(String stageId) {
		this.stageId = stageId;
		return this;
	}

	public List<FailureStatistics> getFailureStatisticsList() {
		if (this.failureStatisticsList == null) {
			this.failureStatisticsList = new ArrayList<>();
		}
		return failureStatisticsList;
	}

	public FailureReason setFailureStatisticsList(List<FailureStatistics> failureStatisticsList) {
		if (this.failureStatisticsList == null) {
			this.failureStatisticsList = new ArrayList<>();
		}
		this.failureStatisticsList = failureStatisticsList;
		return this;
	}

}
