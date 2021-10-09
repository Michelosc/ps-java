package com.supera.inovacao.psjava.dtos.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDtoInput {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private short score;

    @NotBlank
    private String image;

}
