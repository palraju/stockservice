package com.cognizant.stock.persistent;

import com.cognizant.stock.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
