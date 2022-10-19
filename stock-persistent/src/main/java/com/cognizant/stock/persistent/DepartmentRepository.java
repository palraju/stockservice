package com.cognizant.stock.persistent;

import com.cognizant.stock.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
