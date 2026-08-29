package com.ecommerce.clean.produto.application.usecase;

import java.math.BigDecimal;

import com.ecommerce.clean.produto.application.port.out.ProdutoRepositoryPort;
import com.ecommerce.clean.produto.domain.Produto;

public class CriarProdutoUseCase {

    private final ProdutoRepositoryPort repository;

    public CriarProdutoUseCase(ProdutoRepositoryPort repository){
        this.repository = repository;
    }

    public Produto executar(String nome, BigDecimal preco, int quantidadeEstoque){
        Produto produto = new Produto(null, nome, preco, quantidadeEstoque);
        return repository.salvar(produto);
    }

}
