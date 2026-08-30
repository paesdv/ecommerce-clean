package com.ecommerce.clean.usuario.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.clean.usuario.application.port.out.UsuarioRepositoryPort;
import com.ecommerce.clean.usuario.domain.Usuario;

@Service
public class ListarUsuariosUseCase {

    private final UsuarioRepositoryPort repository;

    public ListarUsuariosUseCase(UsuarioRepositoryPort repository){
        this.repository = repository;
    }

    public List<Usuario> executar(){
        return repository.listarTodos();
    } 

}
