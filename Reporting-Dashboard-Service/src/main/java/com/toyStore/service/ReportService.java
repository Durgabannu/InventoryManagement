package com.toyStore.service;

import java.time.LocalDate;
import java.util.List;

import com.toyStore.model.Report;

public interface ReportService {
	List<Report> getReportsByDateRange(LocalDate startDate, LocalDate endDate);
    Report addReport(Report report);
	Report getReportById(Long id);
	List<Report> getAllReports();
	Report updateReport(Long id, Report updatedReport);
	boolean deleteReport(Long id);
}
