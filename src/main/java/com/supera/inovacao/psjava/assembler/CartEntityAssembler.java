package com.supera.inovacao.psjava.assembler;

import com.supera.inovacao.psjava.dtos.CartDto;
import com.supera.inovacao.psjava.dtos.ProductDto;
import com.supera.inovacao.psjava.entities.Cart;
import com.supera.inovacao.psjava.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartEntityAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CartDto toEntity(Cart cart) {
        return modelMapper.map(cart, CartDto.class);
    }

    public List<CartDto> toCollectionEntity(List<Cart> carts) {
        return carts.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
