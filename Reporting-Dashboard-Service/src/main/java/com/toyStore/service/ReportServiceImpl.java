package com.toyStore.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.toyStore.feignClient.OrderFulfillmentFeignClient;
import com.toyStore.model.Order;
import com.toyStore.model.Report;
import com.toyStore.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private OrderFulfillmentFeignClient orderFulfillmentFeignClient;

    @Override
    public List<Report> getReportsByDateRange(LocalDate startDate, LocalDate endDate) {
        return reportRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }
    
    @Override
    public Report getReportById(Long id) {
        Optional<Report> report = reportRepository.findById(id);
        return report.orElse(null);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report updateReport(Long id, Report updatedReport) {
        if (reportRepository.existsById(id)) {
            updatedReport.setId(id);
            return reportRepository.save(updatedReport);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteReport(Long id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    
    public ResponseEntity<?> getOrderByIdFromOrderService(Long id) {
        return orderFulfillmentFeignClient.getOrderById(id);
    }

    public ResponseEntity<List<Order>> getAllOrdersFromOrderService() {
        return orderFulfillmentFeignClient.getAllOrders();
    }
}
