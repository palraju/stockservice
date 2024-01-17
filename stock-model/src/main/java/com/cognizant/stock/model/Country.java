package com.cognizant.stock.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer identifier;

    private String iso2Code;

    private String iso3Code;

    private String shortName;

    private String longName;
}
