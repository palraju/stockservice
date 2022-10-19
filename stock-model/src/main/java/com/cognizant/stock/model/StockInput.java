package com.cognizant.stock.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockInput {
    private String scripName;

    private String scripCode;

    private String scripInceptionDate;

    private String companyName;
}
