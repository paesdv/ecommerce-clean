package com.ecommerce.clean.produto.infrastructure.web.dto;

import java.math.BigDecimal;

public record CriarProdutoRequestDTO(String nome, BigDecimal preco, int quantidadeEstoque) {
}
