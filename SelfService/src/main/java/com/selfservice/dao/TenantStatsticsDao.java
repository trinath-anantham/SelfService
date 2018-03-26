package com.selfservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.selfservice.dto.JobSummary;
import com.selfservice.dto.RequestJson;
import com.selfservice.dto.RequestMap;

@Component
public class TenantStatsticsDao {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<JobSummary> getData(RequestJson requestJson) {
		Query query = new Query();
		prepareSelectClause(query, requestJson.getSelectionMap());
		prepareRestrictionClause(query, requestJson.getRestrictionMap());
		return mongoTemplate.find(query, JobSummary.class);
	}

	private void prepareSelectClause(Query query, List<String> selectionList) {
		if(selectionList != null)
			selectionList.forEach(ele -> {
				query.fields().include(ele);
			});
	}

	private void prepareRestrictionClause(Query query, List<RequestMap> restrictionList) {
		Criteria criteria = Criteria.where("_id").ne(null);
		if(restrictionList != null)
			restrictionList.forEach(requestMap -> {
				criteria.and(requestMap.getKey()).is(requestMap.getValue());
			});
		query.addCriteria(criteria);
	}
}
