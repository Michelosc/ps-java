package com.supera.inovacao.psjava.exception;

public abstract class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
