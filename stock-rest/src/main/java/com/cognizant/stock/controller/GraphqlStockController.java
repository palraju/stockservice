package com.cognizant.stock.controller;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.model.StockInput;
import com.cognizant.stock.service.StockService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class GraphqlStockController {

    private StockService stockService;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    @QueryMapping
    public Collection<Stock> getAllScrip() {
        return stockService.findAll();
    }

    @QueryMapping
    public Stock getScripById (@Argument int stockId) {
        return stockService.findById(stockId);
    }

    @MutationMapping
    public Stock addScrip (@Argument StockInput stockInput) {
        Stock stock = dozerBeanMapper.map(stockInput, Stock.class);
        return stockService.add(stock);
    }
}
