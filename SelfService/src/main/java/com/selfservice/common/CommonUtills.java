package com.selfservice.common;

import java.util.ArrayList;
import java.util.List;

import com.selfservice.dto.RequestJson;
import com.selfservice.dto.RequestMap;

public class CommonUtills {

	public static RequestJson prepareRequestJson(String jobId){
		RequestJson stageRequestJson = new RequestJson();
		RequestMap restictionMap = new RequestMap();
		restictionMap.setKey(Constants.JOB_ID);
		restictionMap.setValue(jobId);
		List<RequestMap> list = new ArrayList<>();
		list.add(restictionMap);
		stageRequestJson.setRestrictionMap(list);
		return null;
	}
}
