package com.cognizant.stock.test.controller;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.service.StockService;
import com.cognizant.stock.test.AbstarctControllerIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StockResourceTest extends AbstarctControllerIntegrationTest {

    @MockBean
    private StockService stockservice;

    private static String BASE_URL = "/api/stock";

    @Test
    public void findByIdTest () throws Exception {
        Stock stock = new Stock();
        stock.setStockId(1);
        stock.setScripCode("COGN");
        Integer id = 1;
        String url = BASE_URL + "/find/{id}";
        when(stockservice.findById(any())).thenReturn(stock);
        this.mockmvc.perform(MockMvcRequestBuilders.get(url,id)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.scripCode")
                        .value("COGN"));
    }

}
