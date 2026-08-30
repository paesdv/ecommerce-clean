package com.ecommerce.clean.usuario.application.usecase;

import org.springframework.stereotype.Service;

import com.ecommerce.clean.usuario.application.port.out.UsuarioRepositoryPort;
import com.ecommerce.clean.usuario.domain.Usuario;

@Service
public class CriarUsuarioUseCase {

    private final UsuarioRepositoryPort repository;

    public CriarUsuarioUseCase(UsuarioRepositoryPort repository){
        this.repository = repository;
    }

    public Usuario executar(String nome, String email, String senha){
        Usuario usuario = new Usuario(null, nome, email, senha);
        return repository.salvar(usuario);
    }


}
