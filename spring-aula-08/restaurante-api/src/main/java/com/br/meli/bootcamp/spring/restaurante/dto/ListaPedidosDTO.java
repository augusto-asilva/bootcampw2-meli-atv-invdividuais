package com.br.meli.bootcamp.spring.restaurante.dto;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidosDTO {
    private List<PedidoDTO> pedidosDTO;
    private double valorTotalDosPedidos;

    public ListaPedidosDTO() {
        this.pedidosDTO = new ArrayList<>();
        this.valorTotalDosPedidos = 0.0;
    }

    public ListaPedidosDTO(List<PedidoDTO> pedidosDTO) {
        this.pedidosDTO = pedidosDTO;
        this.valorTotalDosPedidos = pedidosDTO.stream().mapToDouble(p -> p.getValorTotal()).sum();
    }

    public List<PedidoDTO> getPedidosDTO() {
        return pedidosDTO;
    }

    public void setPedidosDTO(List<PedidoDTO> pedidosDTO) {
        this.pedidosDTO = pedidosDTO;
    }

    public double getValorTotalDosPedidos() {
        return valorTotalDosPedidos;
    }

    public void setValorTotalDosPedidos(double valorTotalDosPedidos) {
        this.valorTotalDosPedidos = valorTotalDosPedidos;
    }
}
