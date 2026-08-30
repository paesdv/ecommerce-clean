package com.ecommerce.clean.usuario.application.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ecommerce.clean.usuario.domain.Usuario;

public interface UsuarioRepositoryPort {

    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(UUID id);
    List<Usuario> listarTodos();
    void deletar(Usuario usuario);

}
