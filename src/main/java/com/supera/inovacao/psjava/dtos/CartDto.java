package com.supera.inovacao.psjava.dtos;

import com.supera.inovacao.psjava.dtos.ProductDto;
import com.supera.inovacao.psjava.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartDto {

    private Long id;

    private BigDecimal shippingRate;

    private List<ProductDto> products;

    private BigDecimal subTotal;

    private BigDecimal total;
}
