package com.br.meli.bootcamp.spring.restaurante.api.entity;

import com.br.meli.bootcamp.spring.restaurante.dto.ListaPedidosDTO;
import com.br.meli.bootcamp.spring.restaurante.dto.PedidoDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Mesa {
    private UUID id;
    private List<Pedido> pedidos;
    private double valorTotalConsumido;

    public Mesa(){
        this.id = UUID.randomUUID();
    }

    public Mesa(List<Pedido> pedidos) {
        this.id = UUID.randomUUID();
        this.pedidos = pedidos;
        this.valorTotalConsumido = pedidos.stream().mapToDouble(p -> p.getValorTotal()).sum();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public ListaPedidosDTO getPedidosDTO() {
        List<PedidoDTO> pedidoDTOs = new ArrayList<>();

        for (Pedido pedido: this.pedidos) {
            pedidoDTOs.add(new PedidoDTO(pedido));
        }

        ListaPedidosDTO listaPedidosDTO = new ListaPedidosDTO(pedidoDTOs);

        return listaPedidosDTO;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public void adicionaPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        this.valorTotalConsumido += pedido.getValorTotal();
    }

    public void removePedido(Pedido pedido) {
        var remove = this.pedidos.remove(pedido);
        this.valorTotalConsumido -= pedido.getValorTotal();
    }
}
