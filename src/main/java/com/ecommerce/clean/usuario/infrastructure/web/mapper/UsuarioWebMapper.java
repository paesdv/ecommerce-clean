package com.ecommerce.clean.usuario.infrastructure.web.mapper;

import org.springframework.stereotype.Component;

import com.ecommerce.clean.usuario.domain.Usuario;
import com.ecommerce.clean.usuario.infrastructure.web.dto.UsuarioResponseDTO;

@Component
public class UsuarioWebMapper {

    public UsuarioResponseDTO toResponseDTO(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getRole()
        );
    }

}
