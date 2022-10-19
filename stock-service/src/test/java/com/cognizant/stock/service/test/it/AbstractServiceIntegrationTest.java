package com.cognizant.stock.service.test.it;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ActiveProfiles("test")
@ComponentScan("com.cognizant.stock.service")
@SpringBootTest
@EnableJpaRepositories("com.cognizant.stock.persistent")
@EntityScan("com.cognizant.stock")
@EnableTransactionManagement
@ContextConfiguration(classes = {ServiceIntegrationTestApplication.class})
public class AbstractServiceIntegrationTest {


}
