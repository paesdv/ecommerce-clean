package com.ecommerce.clean.usuario.infrastructure.persistance.mapper;

import org.springframework.stereotype.Component;

import com.ecommerce.clean.usuario.domain.Usuario;
import com.ecommerce.clean.usuario.infrastructure.persistance.entity.UsuarioJpaEntity;

@Component
public class UsuarioPersistanceMapper {

    public UsuarioJpaEntity toEntity(Usuario usuario){
        if(usuario == null){
            return null;
        }

        UsuarioJpaEntity entity = new UsuarioJpaEntity();
        entity.setId(usuario.getId());
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setSenha(usuario.getSenha());
        entity.setRole(usuario.getRole());
        return entity;
    }

    public Usuario toDomain(UsuarioJpaEntity entity){
    if(entity == null){
        return null;
    }

    return Usuario.reconstituir(
        entity.getId(),
        entity.getNome(),
        entity.getEmail(),
        entity.getSenha(),
        entity.getRole()
        );
    }

}
