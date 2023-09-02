package br.igor.Restaurante.cliente;


import br.igor.Restaurante.endereco.Endereco;

public record ClienteRequestDTO(String nome, Endereco endereco) {
}
