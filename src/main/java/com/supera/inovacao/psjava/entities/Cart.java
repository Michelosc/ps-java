package com.supera.inovacao.psjava.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal shippingRate;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

}
