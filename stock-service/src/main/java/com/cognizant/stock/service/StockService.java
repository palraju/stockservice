package com.cognizant.stock.service;

import com.cognizant.stock.model.Stock;

import java.util.Collection;

public interface StockService {
    Stock findById(Integer stockId);
    Collection<Stock> findAll();
    Stock add (Stock stock);
    void remove (Stock stock);
}
