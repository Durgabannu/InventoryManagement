package com.toyStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyStore.model.Stock;
import com.toyStore.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock replenishStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockByItemId(Long itemId) {
        return stockRepository.findByItemId(itemId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void updateStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

}
