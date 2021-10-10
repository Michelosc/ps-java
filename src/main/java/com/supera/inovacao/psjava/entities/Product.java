package com.supera.inovacao.psjava.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private short score;

    private String image;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
}
