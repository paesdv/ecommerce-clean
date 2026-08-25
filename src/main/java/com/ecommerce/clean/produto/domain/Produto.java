package com.ecommerce.clean.produto.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private UUID id;
    private String nome;
    private BigDecimal preco;
    private int quantidadeEstoque;

    public Produto(UUID id, String nome, BigDecimal preco, int quantidadeEstoque) {
        if(nome == null || nome.isBlank()){
            throw new ProdutoInvalidoException("Nome do produto nao pode ser vazio.");
        }
        if(preco == null || preco.compareTo(BigDecimal.ZERO) < 0){
            throw new ProdutoInvalidoException("Preco nao pode ser negativo");
        }
        if(quantidadeEstoque < 0){
            throw new ProdutoInvalidoException("Quantidade em estoque nao pode ser negativa.");
        }

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void decrementarEstoque(int quantidade){
        if(quantidade > this.quantidadeEstoque){
            throw new EstoqueInsuficienteException(
                    "Estoque insuficiente para o produto " + this.nome +
                            ". Disponivel: " + this.quantidadeEstoque + ", solicitado: " + quantidade
            );
        }
        this.quantidadeEstoque -= quantidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

}
