package com.ecommerce.clean.produto.application.port.out;

import com.ecommerce.clean.produto.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepositoryPort {

    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(UUID id);
    List<Produto> listarTodos();


}
