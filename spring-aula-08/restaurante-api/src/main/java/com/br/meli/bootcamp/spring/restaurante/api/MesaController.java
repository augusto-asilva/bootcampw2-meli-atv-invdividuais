package com.br.meli.bootcamp.spring.restaurante.api;

import com.br.meli.bootcamp.spring.restaurante.api.entity.Mesa;
import com.br.meli.bootcamp.spring.restaurante.api.entity.Pedido;
import com.br.meli.bootcamp.spring.restaurante.api.entity.Prato;
import com.br.meli.bootcamp.spring.restaurante.dto.ListaPedidosDTO;
import com.br.meli.bootcamp.spring.restaurante.dto.PedidoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MesaController {

    private Mesa mesa = new Mesa();

    private List<Mesa> mesas;

    private double caixa;

    @RequestMapping("/restaurante/mesa")
    public ResponseEntity<String> startMesa() {
        Prato lasanha = new Prato(49.99, "Lasanha bolonhesa", 0.750);
        Prato churrasco = new Prato(89.99, "Churrasco bovino", 0.500);
        Prato sarapatel = new Prato(29.99, "Sarapatel", 0.550);

        Pedido pedido1 = new Pedido(mesa, new LinkedList<>(Arrays.asList(lasanha, churrasco)));
        Pedido pedido2 = new Pedido(mesa, new LinkedList<>(Arrays.asList(sarapatel)));

        mesa.setPedidos(new LinkedList<>(Arrays.asList(pedido1, pedido2)));

        mesas = new LinkedList<>();
        mesas.add(mesa);

        return new ResponseEntity<>(mesa.getId().toString(), HttpStatus.OK);
    }

    @RequestMapping("/restaurante/mesa/{mesaId}")
    public ResponseEntity<ListaPedidosDTO> getPedidosPorMesa(@PathVariable String mesaId) {
        System.out.println(mesaId);
        var mesaEncontrada = mesas.stream().filter(m -> m.getId().toString().equals(mesaId)).findAny();
        if(mesaEncontrada.isPresent()) {
            return new ResponseEntity<>(mesaEncontrada.get().getPedidosDTO(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ListaPedidosDTO(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/restaurante/mesa/{mesaId}/pedido/{pedidoId}/fecha")
    public ResponseEntity<String> removePedido(@PathVariable String mesaId, @PathVariable String pedidoId) {
        List<Pedido> pedidos;
        var mesaEncontrada = mesas.stream().filter(m -> m.getId().toString().equals(mesaId)).findAny();
        if(mesaEncontrada.isPresent()) {
            pedidos = mesaEncontrada.get().getPedidos();
        } else {
            return new ResponseEntity<>("Mesa nao encontrada", HttpStatus.NOT_FOUND);
        }

        var pedidoEncontrado = pedidos.stream().filter(p -> p.getId().toString().equals(pedidoId)).findAny();

        if(pedidoEncontrado.isPresent()) {
            mesa.removePedido(pedidoEncontrado.get());
            caixa += pedidoEncontrado.get().getValorTotal();
            return new ResponseEntity<>("Pedido removido", HttpStatus.OK);
        }
        return new ResponseEntity<>("Pedido nao encontrado", HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/restaurante/caixa")
    public ResponseEntity<String> getCaixa() {
        return new ResponseEntity<>("{ \"caixa\": \"" + caixa  + "\"}", HttpStatus.OK);
    }
}
