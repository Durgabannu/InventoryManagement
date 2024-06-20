package com.toyStore.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    
		    private LocalDate date;
		    private String productName;
		    private int quantitySold;
		    private double totalRevenue;
			public Report() {
				super();
			}
			public Report(Long id, LocalDate date, String productName, int quantitySold, double totalRevenue) {
				super();
				this.id = id;
				this.date = date;
				this.productName = productName;
				this.quantitySold = quantitySold;
				this.totalRevenue = totalRevenue;
			}
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public LocalDate getDate() {
				return date;
			}
			public void setDate(LocalDate date) {
				this.date = date;
			}
			public String getProductName() {
				return productName;
			}
			public void setProductName(String productName) {
				this.productName = productName;
			}
			public int getQuantitySold() {
				return quantitySold;
			}
			public void setQuantitySold(int quantitySold) {
				this.quantitySold = quantitySold;
			}
			public double getTotalRevenue() {
				return totalRevenue;
			}
			public void setTotalRevenue(double totalRevenue) {
				this.totalRevenue = totalRevenue;
			}

		    

		}

