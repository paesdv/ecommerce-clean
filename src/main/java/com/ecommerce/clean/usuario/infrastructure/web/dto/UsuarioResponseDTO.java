package com.ecommerce.clean.usuario.infrastructure.web.dto;

import java.util.UUID;

import com.ecommerce.clean.usuario.domain.Role;

public record UsuarioResponseDTO(UUID id, String nome, String email, Role role) {

}
