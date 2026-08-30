package com.ecommerce.clean.usuario.infrastructure.web.dto;

public record CriarUsuarioRequestDTO(
    String nome, 
    String email, 
    String senha
) {

}
