package com.ecommerce.clean.produto.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.clean.produto.application.port.out.ProdutoRepositoryPort;
import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.domain.ProdutoInvalidoException;

@Service
public class BuscarProdutoUseCase {

    private final ProdutoRepositoryPort repository;

    public BuscarProdutoUseCase(ProdutoRepositoryPort repository){
        this.repository = repository;
    }

    public Produto executar(UUID id){
        return repository.buscarPorId(id)
                .orElseThrow(() -> new ProdutoInvalidoException("Produto nao encontrado"));
    }
    
}
