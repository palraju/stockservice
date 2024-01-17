package com.cognizant.stock.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "office")
@Getter
@Setter
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer identifier;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private OfficeType type;


    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;
}
