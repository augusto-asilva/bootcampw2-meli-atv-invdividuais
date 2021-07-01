package com.br.meli.bootcamp.spring.restaurante.dto;

import com.br.meli.bootcamp.spring.restaurante.api.entity.Pedido;
import com.br.meli.bootcamp.spring.restaurante.api.entity.Prato;

import java.util.List;
import java.util.UUID;

public class PedidoDTO {
    private UUID id;
    private List<Prato> pratos;
    private double valorTotal;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.pratos = pedido.getPratos();
        this.valorTotal = pedido.getValorTotal();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
