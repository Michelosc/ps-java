package com.supera.inovacao.psjava.exception;

public class CartNotFoundException extends EntityNotFoundException{

    public CartNotFoundException(String message) {
        super(message);
    }

    public CartNotFoundException(Long cartId) {
        super(String.format("Não existe um cadastro de carrinho com código %d", cartId));
    }
}
