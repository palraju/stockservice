package com.cognizant.stock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Stock")
@Getter
@Setter
public class Stock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockId;

	private String scripName;

	private String scripCode;

	private String scripInceptionDate;

	private String companyName;

}
