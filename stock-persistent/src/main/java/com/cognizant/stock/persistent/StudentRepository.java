package com.cognizant.stock.persistent;

import com.cognizant.stock.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {

}
