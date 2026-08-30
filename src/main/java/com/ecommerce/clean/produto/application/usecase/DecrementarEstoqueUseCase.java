package com.ecommerce.clean.produto.application.usecase;

import com.ecommerce.clean.produto.application.port.out.ProdutoRepositoryPort;
import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.domain.ProdutoNaoEncontradoException;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class DecrementarEstoqueUseCase {

    private final ProdutoRepositoryPort reposository;

    public DecrementarEstoqueUseCase (ProdutoRepositoryPort reposository){
        this.reposository = reposository;
    }

    public Produto executar(UUID id, int quantidade){
        Produto produto = reposository.buscarPorId(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto nao encontrado."));

        produto.decrementarEstoque(quantidade);

        return reposository.salvar(produto);
    }



}
