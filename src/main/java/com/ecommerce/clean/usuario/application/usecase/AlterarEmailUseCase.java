package com.ecommerce.clean.usuario.application.usecase;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.clean.usuario.application.port.out.UsuarioRepositoryPort;
import com.ecommerce.clean.usuario.domain.Usuario;
import com.ecommerce.clean.usuario.domain.UsuarioInvalidoException;

@Service
public class AlterarEmailUseCase {

    private final UsuarioRepositoryPort repository;

    public AlterarEmailUseCase(UsuarioRepositoryPort repository){
        this.repository = repository;
    }

    public void executar(UUID id, String senhaAtual, String novoEmail){
        Usuario usuario = repository.buscarPorId(id)
        .orElseThrow(() -> new UsuarioInvalidoException("Usuario nao encontrado"));
        usuario.alterarEmail(senhaAtual, novoEmail);
        repository.salvar(usuario);
    }

}
