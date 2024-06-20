package com.toyStore.FeignClient;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.toyStore.model.Report;
@FeignClient(name = "reporting-dashboard-service", url = "http://localhost:8074")
public interface ReportingFeignClient {
		@GetMapping("/reports/all")
	    public ResponseEntity<List<Report>> getAllReports();
	
}
