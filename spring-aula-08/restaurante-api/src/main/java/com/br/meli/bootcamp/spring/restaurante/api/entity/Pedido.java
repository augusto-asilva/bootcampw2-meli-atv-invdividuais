package com.br.meli.bootcamp.spring.restaurante.api.entity;

import java.util.List;
import java.util.UUID;

public class Pedido {
    private UUID id;
    private Mesa mesa;
    private List<Prato> pratos;
    private double valorTotal;

    public Pedido(Mesa mesa, List<Prato> pratos) {
        this.id = UUID.randomUUID();
        this.mesa = mesa;
        this.pratos = pratos;
        this.valorTotal = pratos.stream().mapToDouble(p -> p.getPreco()).sum();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }


}
