package com.ecommerce.clean.produto.domain;

public class ProdutoInvalidoException extends RuntimeException {
    public ProdutoInvalidoException(String message) {
        super(message);
    }
}
