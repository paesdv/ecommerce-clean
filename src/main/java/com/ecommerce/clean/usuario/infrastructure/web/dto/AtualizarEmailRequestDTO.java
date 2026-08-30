package com.ecommerce.clean.usuario.infrastructure.web.dto;

public record AtualizarEmailRequestDTO(
    String senhaAtual, 
    String novoEmail
) {
}
