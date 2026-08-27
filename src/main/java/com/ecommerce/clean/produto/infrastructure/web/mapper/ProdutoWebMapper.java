package com.ecommerce.clean.produto.infrastructure.web.mapper;

import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.infrastructure.web.dto.ProdutoResponseDTO;

public class ProdutoWebMapper {

    public static ProdutoResponseDTO toResponseDTO(Produto produto){
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidadeEstoque()
        );
    }

}
