package com.ecommerce.clean.produto.infrastructure.web.controller;

import com.ecommerce.clean.produto.application.usecase.BuscarProdutoUseCase;
import com.ecommerce.clean.produto.application.usecase.CriarProdutoUseCase;
import com.ecommerce.clean.produto.application.usecase.DecrementarEstoqueUseCase;
import com.ecommerce.clean.produto.application.usecase.ListarProdutosUseCase;
import com.ecommerce.clean.produto.domain.Produto;
import com.ecommerce.clean.produto.infrastructure.web.dto.CriarProdutoRequestDTO;
import com.ecommerce.clean.produto.infrastructure.web.dto.DecrementarEstoqueRequestDTO;
import com.ecommerce.clean.produto.infrastructure.web.dto.ProdutoResponseDTO;
import com.ecommerce.clean.produto.infrastructure.web.mapper.ProdutoWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final CriarProdutoUseCase criarProdutoUseCase;
    private final DecrementarEstoqueUseCase decrementarEstoqueUseCase;
    private final ListarProdutosUseCase listarProdutosUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable UUID id){
        Produto produto = buscarProdutoUseCase.executar(id);

        return ResponseEntity.ok(ProdutoWebMapper.toResponseDTO(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@RequestBody CriarProdutoRequestDTO dto){
        Produto produto = criarProdutoUseCase.executar(dto.nome(), dto.preco(), dto.quantidadeEstoque());
        return ResponseEntity.ok(ProdutoWebMapper.toResponseDTO(produto));
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<ProdutoResponseDTO> decrementarEstoque(@PathVariable UUID id, @RequestBody DecrementarEstoqueRequestDTO dto){
        Produto produto = decrementarEstoqueUseCase.executar(id, dto.quantidade());
        return ResponseEntity.ok(ProdutoWebMapper.toResponseDTO(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar(){
        List<ProdutoResponseDTO> produtos = listarProdutosUseCase.executar().stream()
                .map(ProdutoWebMapper::toResponseDTO)
                .toList();
        return ResponseEntity.ok(produtos);
    }

}
