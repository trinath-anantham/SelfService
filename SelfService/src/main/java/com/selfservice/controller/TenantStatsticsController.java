package com.selfservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.selfservice.dto.JobSummary;
import com.selfservice.dto.RequestJson;
import com.selfservice.dto.Result;
import com.selfservice.service.TenantStatsticsService;

@Controller
@RequestMapping("/selfservice")
public class TenantStatsticsController {

	@Autowired
	TenantStatsticsService tenantStatsticsService;

	@GetMapping("/test")
	@ResponseBody
	private List<JobSummary> test() {
		return tenantStatsticsService.getTenantStatsticsByTenantId("1990");
	}

	@PostMapping("/getStatsticsByTenantIdAndFromDateAndToDate")
	@ResponseBody
	private List<Result> getStatsticsByTenantIdAndFromDateAndToDate(@RequestBody RequestJson requestJson) {
		return tenantStatsticsService.getStatsticsByTenantIdAndFromDateAndToDate(requestJson);
	}

	@GetMapping("/greeting")
	public String greeting(String name, Model model) {
		return "/WebContent/html/index.html";
	}

	@PostMapping("/getTenantStatstics")
	@ResponseBody
	private List<JobSummary> getTenantStatstics(@RequestBody RequestJson requestJson) {
		return tenantStatsticsService.getData(requestJson);
	}

}