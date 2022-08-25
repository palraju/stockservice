package com.cognizant.stock.test;


import com.cognizant.stock.StockServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@SpringBootTest(classes = StockServiceApplication.class , webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AbstarctControllerIntegrationTest {

    @Autowired
    protected MockMvc mockmvc;

    @TestConfiguration
    static class ServiceConfiguration {

    }

}
