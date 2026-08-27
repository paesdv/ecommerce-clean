package com.ecommerce.clean.produto.infrastructure.web.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDTO(
        UUID id,
        String nome,
        BigDecimal preco,
        int quantidadeEstoque
) {
}
