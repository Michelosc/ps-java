package com.supera.inovacao.psjava.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal shippingRate = BigDecimal.ZERO;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    private BigDecimal subTotal = BigDecimal.ZERO;

    private BigDecimal total;

    public void addProduct(Product product) {
        products.add(product);
        this.subTotal = subTotal.add(product.getPrice());
        addShippingRate();
    }

    public void removeProduct(Product product) {
        this.subTotal = subTotal.subtract(product.getPrice());
        products.remove(product);
        removeShippingRate();
    }

    public void addShippingRate() {
        this.shippingRate = shippingRate.add(new BigDecimal("10"));
    }

    public void removeShippingRate() { this.shippingRate = shippingRate.subtract(new BigDecimal("10"));}

    public void calculateTotalShippingRate() {
        BigDecimal discountValue = new BigDecimal("250");
        if(this.subTotal.compareTo(discountValue) >= 0) {
            this.shippingRate = BigDecimal.ZERO;
        }
    }

    public void checkout() {
        calculateTotalShippingRate();
        this.total = subTotal.add(shippingRate);
    }

}
