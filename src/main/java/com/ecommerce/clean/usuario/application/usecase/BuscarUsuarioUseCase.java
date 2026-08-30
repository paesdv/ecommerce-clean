package com.ecommerce.clean.usuario.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.clean.usuario.application.port.out.UsuarioRepositoryPort;
import com.ecommerce.clean.usuario.domain.Usuario;
import com.ecommerce.clean.usuario.domain.UsuarioInvalidoException;

@Service
public class BuscarUsuarioUseCase {

    private final UsuarioRepositoryPort repository;

    public BuscarUsuarioUseCase(UsuarioRepositoryPort repository){
        this.repository = repository;
    }

    public Usuario executar(UUID id){
        return repository.buscarPorId(id)
        .orElseThrow(() -> new UsuarioInvalidoException("Usuario nao encontrado"));
    }

}
