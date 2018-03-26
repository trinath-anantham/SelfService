package com.selfservice.dto;

import org.springframework.data.annotation.Id;

public class DailySummary {

	@Id
	private String id;
	private boolean dummy;
	private String date;
	private String groovyFileName;
	private String statisticsJsonContent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public DailySummary setDate(String date) {
		this.date = date;
		return this;
	}

	public boolean isDummy() {
		return dummy;
	}

	public DailySummary setDummy(boolean dummy) {
		this.dummy = dummy;
		return this;
	}

	public String getGroovyFileName() {
		return groovyFileName;
	}

	public DailySummary setGroovyFileName(String groovyFileName) {
		this.groovyFileName = groovyFileName;
		return this;
	}

	public String getStatisticsJsonContent() {
		return statisticsJsonContent;
	}

	public DailySummary setStatisticsJsonContent(String statisticsJsonContent) {
		this.statisticsJsonContent = statisticsJsonContent;
		return this;
	}

}
