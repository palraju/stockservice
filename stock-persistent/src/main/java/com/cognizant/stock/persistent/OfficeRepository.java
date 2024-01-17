package com.cognizant.stock.persistent;

import com.cognizant.stock.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
