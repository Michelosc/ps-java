package com.supera.inovacao.psjava.assembler;

import com.supera.inovacao.psjava.dtos.ProductDto;
import com.supera.inovacao.psjava.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductEntityAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDto toEntity(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public List<ProductDto> toCollectionEntity(List<Product> products) {
        return products.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
