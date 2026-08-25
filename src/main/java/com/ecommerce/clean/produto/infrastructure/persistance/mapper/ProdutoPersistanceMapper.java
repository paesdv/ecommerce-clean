package com.ecommerce.clean.produto.infrastructure.persistance.mapper;

import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.infrastructure.persistance.entity.ProdutoJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPersistanceMapper {

    public ProdutoJpaEntity toEntity(Produto produto){
        if(produto == null){
            return null;
        }

        ProdutoJpaEntity entity = new ProdutoJpaEntity();
        entity.setId(produto.getId());
        entity.setNome(produto.getNome());
        entity.setPreco(produto.getPreco());
        entity.setQuantidadeEstoque(produto.getQuantidadeEstoque());

        return entity;
    }

    public Produto toDomain(ProdutoJpaEntity entity){
        if(entity == null){
            return null;
        }

        return new Produto(
                entity.getId(),
                entity.getNome(),
                entity.getPreco(),
                entity.getQuantidadeEstoque()
        );

    }


}
