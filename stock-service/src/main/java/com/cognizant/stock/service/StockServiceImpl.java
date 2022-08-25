package com.cognizant.stock.service;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.persistent.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
		return null;
	}

	public Collection<Stock> findAll() {
		return stockRepository.findAll();
	}

	public Stock add (Stock stock) {
		if(stock == null) {
			new RuntimeException("Stock can not be empty");
		}
		stockRepository.save(stock);
		return stock;
	}
}
