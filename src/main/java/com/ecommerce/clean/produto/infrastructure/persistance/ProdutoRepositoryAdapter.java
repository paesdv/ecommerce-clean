package com.ecommerce.clean.produto.infrastructure.persistance;

import com.ecommerce.clean.produto.application.port.out.ProdutoRepositoryPort;
import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.infrastructure.persistance.entity.ProdutoJpaEntity;
import com.ecommerce.clean.produto.infrastructure.persistance.mapper.ProdutoPersistanceMapper;
import com.ecommerce.clean.produto.infrastructure.persistance.repository.SpringDataProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoPersistanceMapper persistanceMapper;
    private final SpringDataProdutoRepository repository;

    @Override
    public Produto salvar(Produto produto){
        ProdutoJpaEntity entity = persistanceMapper.toEntity(produto);
        ProdutoJpaEntity entitySalva = repository.save(entity);
        return persistanceMapper.toDomain(entitySalva);
    }

    @Override
    public Optional<Produto> buscarPorId(UUID id){
        Optional<ProdutoJpaEntity> entityOpt = repository.findById(id);
        return entityOpt.map(persistanceMapper::toDomain);
    }

    @Override
    public List<Produto> listarTodos(){
        List<ProdutoJpaEntity> entityList = repository.findAll();
        return entityList.stream()
                .map(persistanceMapper::toDomain)
                .toList();
    }


}
