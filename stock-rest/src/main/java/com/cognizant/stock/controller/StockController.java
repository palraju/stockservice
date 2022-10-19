package com.cognizant.stock.controller;


import com.cognizant.stock.model.Stock;
import com.cognizant.stock.model.StockServiceResponse;
import com.cognizant.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StockController {

	private StockService stockService;

	@Autowired
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	@RequestMapping("/api/stock/find/{id}")
	public Stock findById(@PathVariable Integer id) {
		return stockService.findById(id);
	}

	@RequestMapping("/api/stock/findAll")
	public StockServiceResponse<Stock> findAll() {
		StockServiceResponse<Stock> stockListResponseObj = new StockServiceResponse<Stock>();
		stockListResponseObj.setDataList(stockService.findAll());
		return stockListResponseObj;
	}

	@PostMapping("/api/stock/add")
	public Stock add (@RequestBody Stock stock) {
		return stockService.add(stock);
	}
}