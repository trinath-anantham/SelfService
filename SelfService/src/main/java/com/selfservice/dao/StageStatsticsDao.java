package com.selfservice.dao;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.lookup;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.selfservice.common.Constants;
import com.selfservice.dto.RequestJson;
import com.selfservice.dto.RequestMap;
import com.selfservice.dto.Result;
import com.selfservice.dto.StageSummary;

@Component
public class StageStatsticsDao {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<StageSummary> getData(RequestJson requestJson) {
		Query query = new Query();
		prepareSelectClause(query, requestJson.getSelectionMap());
		prepareRestrictionClause(query, requestJson.getRestrictionMap());
		return mongoTemplate.find(query, StageSummary.class);
	}

	private void prepareSelectClause(Query query, List<String> selectionList) {
		selectionList.forEach(ele -> {
			query.fields().include(ele);
		});
	}

	private void prepareRestrictionClause(Query query, List<RequestMap> restrictionList) {
		Criteria criteria = Criteria.where("_id").ne(null);
		restrictionList.forEach(requestMap -> {
			criteria.and(requestMap.getKey()).is(requestMap.getValue());
		});
		query.addCriteria(criteria);
	}

	public List<Result> getAggrigation(List<RequestMap> restrictionList) {
		List<Result> resultList = new ArrayList<>();
		if (restrictionList != null) {
			Criteria criteria = prepareWhereCriteria();
			restrictionList.forEach(requestMap -> {
				prepareAndCriteria(criteria, requestMap.getKey(), requestMap.getValue());
			});
			AggregationOperation matchOperation = match(criteria);
			resultList.addAll(getAggrigation(matchOperation));
		}
		return resultList;
	}

	public List<Result> getAggrigation(AggregationOperation matchOperation) {
		Aggregation aggregation = newAggregation(matchOperation,
				lookup(Constants.STAGE_SUMMARY, Constants.ID, Constants.JOB_ID, Constants.STAGE_DOCS_ARRAY),
				unwind(Constants.STAGE_DOCS_ARRAY), unwind(Constants.STAGE_DOCS_FILE_BASED_STATSTICS),
				group(Fields.from(Fields.field("jobId", "$_id"),
						Fields.field("inputFileName", "$stageDocsArray.fileBasedStatisticsList.inputFileName"),
						Fields.field("stageName", "$stageDocsArray.stageName")))
								.push(new BasicDBObject("tenantId", "$tenantId").append("tenantName", "$tenantName")
										.append("groovyFileName", "$groovyFileName").append("startTime", "$startTime")
										.append("endTime", "$endTime"))
								.as("values").sum("stageDocsArray.fileBasedStatisticsList.successCount").as("success")
								.sum("stageDocsArray.fileBasedStatisticsList.failureCount").as("failure")
								.sum("stageDocsArray.fileBasedStatisticsList.skipCount")
								.as("skip"),
				unwind("values"),
				group(Fields.from(Fields.field("jobId", "$_id.jobId")))
						.push(new BasicDBObject("tenantId", "$values.tenantId")
								.append("tenantName", "$values.tenantName")
								.append("groovyFileName", "$values.groovyFileName")
								.append("startTime", "$values.startTime").append("endTime", "$values.endTime")
								.append("fileName", "$_id.inputFileName").append("name", "$_id.stageName")
								.append("success", "$success").append("failure", "$failure").append("skip", "$skip"))
						.as("values"),
				project("values"));

		AggregationResults<Result> output = mongoTemplate.aggregate(aggregation, "jobSummary", Result.class);
		System.out.println(output.getMappedResults());
		return output.getMappedResults();
	}

	private Criteria prepareWhereCriteria() {
		return Criteria.where("fatal").in(false);
	}

	private void prepareAndCriteria(Criteria criteria, String key, Object value) {
		criteria = criteria.and(key).in(value);
	}
}
