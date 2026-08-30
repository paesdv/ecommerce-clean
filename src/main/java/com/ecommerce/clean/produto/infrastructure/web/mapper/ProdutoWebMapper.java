package com.ecommerce.clean.produto.infrastructure.web.mapper;

import org.springframework.stereotype.Component;

import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.infrastructure.web.dto.ProdutoResponseDTO;

@Component
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
