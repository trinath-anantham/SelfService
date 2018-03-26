package com.selfservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stageSummary")
public class StageSummary {

	public static final String JOB_ID = "jobId";
	public static final String STAGE_NAME = "stageName";
	public static final String STAGE_ID = "stageId";
	public static final String START_DATE = "startDate";
	public static final String END_DATE = "endDate";
	@Id
	private String id;
	private String jobId;
	private String stageId;
	private String stageName;
	private List<FileBasedStatistics> fileBasedStatisticsList;

	public String getId() {
		return id;
	}

	public StageSummary setId(String id) {
		this.id = id;
		return this;
	}

	public String getJobId() {
		return jobId;
	}

	public StageSummary setJobId(String jobId) {
		this.jobId = jobId;
		return this;
	}

	public String getStageId() {
		return stageId;
	}

	public StageSummary setStageId(String stageId) {
		this.stageId = stageId;
		return this;
	}

	public String getStageName() {
		return stageName;
	}

	public StageSummary setStageName(String stageName) {
		this.stageName = stageName;
		return this;
	}

	public List<FileBasedStatistics> getFileBasedStatisticsList() {
		if (this.fileBasedStatisticsList == null) {
			this.fileBasedStatisticsList = new ArrayList<>();
		}
		return fileBasedStatisticsList;
	}

	public StageSummary setFileBasedStatisticsList(List<FileBasedStatistics> fileBasedStatisticsList) {
		if (this.fileBasedStatisticsList == null) {
			this.fileBasedStatisticsList = new ArrayList<>();
		}
		this.fileBasedStatisticsList = fileBasedStatisticsList;
		return this;
	}

}
