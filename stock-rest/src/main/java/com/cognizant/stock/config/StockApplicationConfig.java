package com.cognizant.stock.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class StockApplicationConfig {

    @Bean(name = "dozerBeanMapper")
    public DozerBeanMapper getDozerMapper () {
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.setMappingFiles(Collections.singletonList("dozerMapping.xml"));
        return dozer;
    }
}
