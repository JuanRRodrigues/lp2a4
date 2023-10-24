package br.igor.Restaurante.cliente;

import br.igor.Restaurante.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(

        @NotNull
        Long id,
        String nome,
        String email,
        DadosEndereco endereco) {
}
