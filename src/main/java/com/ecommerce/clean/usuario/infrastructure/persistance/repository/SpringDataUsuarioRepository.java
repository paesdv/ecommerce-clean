package com.ecommerce.clean.usuario.infrastructure.persistance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.clean.usuario.infrastructure.persistance.entity.UsuarioJpaEntity;


public interface SpringDataUsuarioRepository  extends JpaRepository<UsuarioJpaEntity, UUID>{
}
