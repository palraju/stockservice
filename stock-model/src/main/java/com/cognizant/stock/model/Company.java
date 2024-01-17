package com.cognizant.stock.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer identifier;

    private String name;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Office> offices;
}
