package com.selfservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selfservice.dao.StageStatsticsDao;
import com.selfservice.dao.TenantStatsticsDao;
import com.selfservice.dto.JobSummary;
import com.selfservice.dto.RequestJson;
import com.selfservice.dto.Result;
import com.selfservice.repository.DailySummaryRepository;
import com.selfservice.repository.JobSummaryRepository;

@Service
public class TenantStatsticsService {

	@Autowired
	DailySummaryRepository dailySummaryRepository;

	@Autowired
	JobSummaryRepository jobSummaryRepository;

	@Autowired
	TenantStatsticsDao tenantStatsticsDao;

	@Autowired
	StageStatsticsDao stageStatsticsDao;

	public List<JobSummary> getTenantStatsticsByTenantId(String tenantId) {
		return jobSummaryRepository.findAll();
	}

	public List<JobSummary> getData(RequestJson requestJson) {
		return tenantStatsticsDao.getData(requestJson);
	}

	public List<Result> getStatsticsByTenantIdAndFromDateAndToDate(RequestJson requestJson) {
//		List<JobSummary> list = tenantStatsticsDao.getData(requestJson);
		return stageStatsticsDao.getAggrigation(requestJson.getRestrictionMap());
	}

}