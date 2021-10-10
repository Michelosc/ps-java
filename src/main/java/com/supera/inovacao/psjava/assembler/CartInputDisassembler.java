package com.supera.inovacao.psjava.assembler;

import com.supera.inovacao.psjava.dtos.input.CartDtoInput;
import com.supera.inovacao.psjava.entities.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cart toDomainObject(CartDtoInput cartDtoInput) {
        return modelMapper.map(cartDtoInput, Cart.class);
    }
}
