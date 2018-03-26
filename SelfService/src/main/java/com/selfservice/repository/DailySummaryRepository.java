package com.selfservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.selfservice.dto.DailySummary;

public interface DailySummaryRepository extends MongoRepository<DailySummary, String> {

	List<DailySummary> findAll();

	List<DailySummary> findByGroovyFileName(String groovyFileName);
}
