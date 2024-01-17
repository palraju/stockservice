package com.cognizant.stock.persistent;

import com.cognizant.stock.model.Company;
import com.cognizant.stock.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
