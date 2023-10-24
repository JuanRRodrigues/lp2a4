package br.igor.Restaurante.pedido;

import br.igor.Restaurante.cardapio.CardapioResponseDTO;
import br.igor.Restaurante.cliente.ClienteResponseDTO;

import java.util.List;

public record PedidoResponseDTO(Long id, String title, ClienteResponseDTO cliente, List<CardapioResponseDTO> pratos) {
    public PedidoResponseDTO(Pedido pedido){
        this(pedido.getId(), pedido.getTitulo(), new ClienteResponseDTO(pedido.getCliente()), pedido.getPratos().stream().map(CardapioResponseDTO::new).toList());
    }
}
