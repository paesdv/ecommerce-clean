package com.ecommerce.clean.usuario.infrastructure.persistance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ecommerce.clean.usuario.application.port.out.UsuarioRepositoryPort;
import com.ecommerce.clean.usuario.domain.Usuario;
import com.ecommerce.clean.usuario.infrastructure.persistance.entity.UsuarioJpaEntity;
import com.ecommerce.clean.usuario.infrastructure.persistance.mapper.UsuarioPersistanceMapper;
import com.ecommerce.clean.usuario.infrastructure.persistance.repository.SpringDataUsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort{

    private final UsuarioPersistanceMapper persistanceMapper;
    private final SpringDataUsuarioRepository repository;

    @Override
    public Usuario salvar(Usuario usuario){
        UsuarioJpaEntity entity = persistanceMapper.toEntity(usuario);
        UsuarioJpaEntity entitySalva = repository.save(entity);
        return persistanceMapper.toDomain(entitySalva);
    }

    @Override
    public Optional<Usuario> buscarPorId(UUID id){
        Optional<UsuarioJpaEntity> entityOpt = repository.findById(id);
        return entityOpt.map(persistanceMapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos(){
        List<UsuarioJpaEntity> entityList = repository.findAll();
        return entityList.stream()
        .map(persistanceMapper::toDomain)
        .toList();
    }

    @Override
    public void deletar(Usuario usuario){
        repository.deleteById(usuario.getId());
    }

}
