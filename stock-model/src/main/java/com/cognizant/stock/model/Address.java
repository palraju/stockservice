package com.cognizant.stock.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer identifier;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String zip;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

}
