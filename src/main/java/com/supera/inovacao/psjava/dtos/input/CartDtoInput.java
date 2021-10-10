package com.supera.inovacao.psjava.dtos.input;

import com.supera.inovacao.psjava.dtos.ProductDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class CartDtoInput {

    @Size(min = 1)
    private List<ProductDtoIdInput> productIds;

}
