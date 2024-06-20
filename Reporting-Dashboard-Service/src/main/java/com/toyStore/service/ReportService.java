package com.toyStore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.toyStore.model.Order;
import com.toyStore.model.Report;

public interface ReportService {
	List<Report> getReportsByDateRange(LocalDate startDate, LocalDate endDate);
    Report addReport(Report report);
	Report getReportById(Long id);
	List<Report> getAllReports();
	Report updateReport(Long id, Report updatedReport);
	boolean deleteReport(Long id);
	ResponseEntity<?> getOrderByIdFromOrderService(Long id);
	ResponseEntity<List<Order>> getAllOrdersFromOrderService();
}
