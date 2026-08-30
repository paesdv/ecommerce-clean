package com.ecommerce.clean.usuario.infrastructure.web.dto;

public record AtualizarSenhaRequestDTO(
    String senhaAtual,
    String novaSenha
) {

}
