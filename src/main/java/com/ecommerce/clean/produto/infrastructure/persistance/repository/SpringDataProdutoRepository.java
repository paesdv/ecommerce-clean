package com.ecommerce.clean.produto.infrastructure.persistance.repository;

import com.ecommerce.clean.produto.infrastructure.persistance.entity.ProdutoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataProdutoRepository extends JpaRepository<ProdutoJpaEntity, UUID> {
}
