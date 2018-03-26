package com.selfservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.selfservice.dto.JobSummary;

public interface JobSummaryRepository extends MongoRepository<JobSummary, String> {

	List<JobSummary> findAll();

	List<JobSummary> findByTenantId(String tenantId);

	List<JobSummary> findByGroovyFileName(String groovyFileName);

	@Query("{ ?0 : ?1 }")
	List<JobSummary> findByDynamicField(String field, Object value);
}
