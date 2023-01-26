package com.cognizant.stock.service.impl;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.persistent.StockRepository;
import com.cognizant.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;


	public Stock findById(Integer stockId) {
		Optional<Stock> stockOptional = stockRepository.findById(stockId);
		if(stockOptional.isPresent()) {
			return stockOptional.get();
		}
		return new Stock ();
	}

	public Collection<Stock> findAll() {
		return stockRepository.findAll();
	}

	public Stock add (Stock stock) {
		if(stock == null) {
			new RuntimeException("Stock can not be empty");
		}
		Stock savedStock = stockRepository.save(stock);
		return savedStock;
	}

	@Override
	public void remove(Stock stock) {
		if(stock == null || stock.getStockId() == null) {
			new RuntimeException("Stock or Stock Id is not provided");
		}
		Optional<Stock> stockOptional = stockRepository.findById(stock.getStockId());
		if(stockOptional.isPresent()) {
			stockRepository.delete(stockOptional.get());
		}
	}
}
