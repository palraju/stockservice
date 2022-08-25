package com.cognizant.stock.persistent;

import com.cognizant.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository <Stock, Integer> {

}
