package com.ecommerce.clean.produto.infrastructure.config;

import com.ecommerce.clean.produto.application.port.out.ProdutoRepositoryPort;
import com.ecommerce.clean.produto.application.usecase.BuscarProdutoUseCase;
import com.ecommerce.clean.produto.application.usecase.CriarProdutoUseCase;
import com.ecommerce.clean.produto.application.usecase.DecrementarEstoqueUseCase;
import com.ecommerce.clean.produto.application.usecase.ListarProdutosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    public CriarProdutoUseCase criarProdutoUseCase(ProdutoRepositoryPort repository) {
        return new CriarProdutoUseCase(repository);
    }

    @Bean
    public BuscarProdutoUseCase buscarProdutoUseCase(ProdutoRepositoryPort repository){
        return new BuscarProdutoUseCase(repository);
    }

    @Bean
   public DecrementarEstoqueUseCase decrementarEstoqueUseCase(ProdutoRepositoryPort repository){
        return new DecrementarEstoqueUseCase(repository);
   }

   @Bean
   public ListarProdutosUseCase listarProdutosUseCase(ProdutoRepositoryPort repository){
        return new ListarProdutosUseCase(repository);
   }

}
