package com.cognizant.stock.service.test.it;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.service.StockService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

@Tag("service")
public class StockServiceTest extends AbstractServiceIntegrationTest{

    private StockService stockService;

    @Autowired
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    private Stock getDummyStock (String stockPrefix) {
        Stock stock = new Stock();
        stock.setScripCode(stockPrefix);
        stock.setCompanyName(stockPrefix + "Compnay");
        stock.setScripInceptionDate("08/08/2022");
        stock.setScripName(stockPrefix + "Scrip");
        return stock;
    }

    @Test
    void crudTesting () {
        Stock dummyScrip1 = getDummyStock("DUMMY1");
        dummyScrip1 = stockService.add(dummyScrip1);
        Assert.isTrue(dummyScrip1 != null && dummyScrip1.getStockId() != null
                && dummyScrip1.getStockId() > 0 , "Unable to insert Stock Details");
        Collection<Stock> stockList = stockService.findAll();
        Assert.isTrue(stockList.parallelStream().anyMatch(x->x.getScripCode()
                .equalsIgnoreCase("DUMMY1")), "Unable to find DUMMY1 scrip");
        stockService.remove(dummyScrip1);
        stockList = stockService.findAll();
        Assert.isTrue(stockList.parallelStream().noneMatch(x->x.getScripCode()
                .equalsIgnoreCase("DUMMY1")), "Able to find DUMMY1 scrip");
    }

    @Test
    void findAll () {
        Collection<Stock> stockList = stockService.findAll();
        Assert.isTrue(!CollectionUtils.isEmpty(stockList), "Collection is Empty");
        System.out.println("Stock List" + stockList);
    }

}
