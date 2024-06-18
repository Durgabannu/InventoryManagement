package com.toyStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toyStore.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock findByItemId(Long itemId);

}
