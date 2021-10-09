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

    private BigDecimal subTotal;

    private BigDecimal total;

    public void addProduct(Product product) {
        products.add(product);
        addShippingRate();
    }

    public void addShippingRate() {
        setShippingRate(new BigDecimal(10));
    }

    public void calculateTotalShippingRate() {
        BigDecimal discountValue = new BigDecimal(250);
        if(shippingRate.compareTo(discountValue) >= 0) {
            setShippingRate(BigDecimal.ZERO);
        }
    }

}
