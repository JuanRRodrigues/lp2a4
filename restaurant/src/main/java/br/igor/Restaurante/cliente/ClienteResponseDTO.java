package br.igor.Restaurante.cliente;


import br.igor.Restaurante.endereco.Endereco;

public record ClienteResponseDTO(Long id, String nome, Endereco endereco/*, List<PedidoResponseDTO> pedidos*/) {
    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEndereco()/*, cliente.getPedidos().stream().map(PedidoResponseDTO::new).toList()*/);
    }
}
