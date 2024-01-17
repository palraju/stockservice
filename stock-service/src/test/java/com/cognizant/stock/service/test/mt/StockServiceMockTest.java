package com.cognizant.stock.service.test.mt;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.persistent.StockRepository;
import com.cognizant.stock.service.impl.StockServiceImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@Tag("unit")
@ExtendWith(MockitoExtension.class)
public class StockServiceMockTest {

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockServiceImpl;

    private Stock getDummyStock (String stockPrefix) {
        Stock stock = new Stock();
        stock.setScripCode(stockPrefix);
        //stock.setCompanyName(stockPrefix + "Compnay");
        stock.setScripInceptionDate("08/08/2022");
        stock.setScripName(stockPrefix + "Scrip");
        return stock;
    }

    @Test
    void testAddStock () {
        Stock dummyScrip1 = getDummyStock("DUMMY1");

        Stock dummyScrip2 = getDummyStock("DUMMY1");
       dummyScrip2.setIdentifier(1);

        lenient().when(stockRepository.save(any(Stock.class))).thenReturn(dummyScrip2);
        Stock dummyScripActual = stockServiceImpl.add(dummyScrip1);
        Assert.isTrue(dummyScripActual.equals(dummyScrip2), "Data Saving not working");
    }

}
