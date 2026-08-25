package com.ecommerce.clean.produto.application.usecase;

import com.ecommerce.clean.produto.application.port.out.ProdutoRepositoryPort;
import com.ecommerce.clean.produto.domain.Produto;

import java.util.List;

public class ListarProdutosUseCase {

    private final ProdutoRepositoryPort repository;

    public ListarProdutosUseCase(ProdutoRepositoryPort repository){
        this.repository = repository;
    }

    public List<Produto> executar(){
        return repository.listarTodos().stream()
                .filter(produto -> produto.getQuantidadeEstoque() > 0)
                .toList();
    }

}
