package com.supera.inovacao.psjava.assembler;

import com.supera.inovacao.psjava.dtos.input.ProductDtoInput;
import com.supera.inovacao.psjava.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductnputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Product toDomainObject(ProductDtoInput productDtoInput) {
        return modelMapper.map(productDtoInput, Product.class);
    }
}
