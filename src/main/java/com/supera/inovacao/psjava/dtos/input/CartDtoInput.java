package com.supera.inovacao.psjava.dtos.input;

import com.supera.inovacao.psjava.dtos.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDtoInput {

    private List<ProductDto> products;

}
