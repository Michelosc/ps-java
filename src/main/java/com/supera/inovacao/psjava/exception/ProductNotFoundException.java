package com.supera.inovacao.psjava.exception;

public class ProductNotFoundException extends EntityNotFoundException{

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long productId) {
        super(String.format("Não existe um cadastro de produto com código %d", productId));
    }
}
