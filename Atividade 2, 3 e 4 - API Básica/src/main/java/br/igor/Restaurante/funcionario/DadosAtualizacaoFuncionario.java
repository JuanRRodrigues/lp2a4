package br.igor.Restaurante.funcionario;

import br.igor.Restaurante.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoFuncionario(

        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {
}
