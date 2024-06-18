package com.toyStore.service;

import java.util.List;

import com.toyStore.model.Stock;

public interface StockService {
	 Stock replenishStock(Stock stock);
	    Stock getStockByItemId(Long itemId);
	    List<Stock> getAllStocks();
	    void updateStock(Stock stock);
	    void deleteStock(Long id);
}
