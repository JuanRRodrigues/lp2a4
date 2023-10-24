package br.igor.Restaurante.pedido;

import java.util.List;

public record PedidoRequestDTO(String title, Long cliente, List<Long> pratos) {
}
