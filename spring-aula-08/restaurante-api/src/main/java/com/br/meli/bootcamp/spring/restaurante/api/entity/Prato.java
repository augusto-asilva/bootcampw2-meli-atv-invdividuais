package com.br.meli.bootcamp.spring.restaurante.api.entity;

import java.util.UUID;

public class Prato {
    private UUID id;
    private double preco;
    private String descricao;
    private double quantidade;

    public Prato(double preco, String descricao, double quantidade) {
        this.id = UUID.randomUUID();
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
