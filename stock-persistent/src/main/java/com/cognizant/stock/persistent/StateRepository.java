package com.cognizant.stock.persistent;

import com.cognizant.stock.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
