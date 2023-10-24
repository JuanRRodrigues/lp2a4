package br.igor.Restaurante.funcionario;

import br.igor.Restaurante.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record DadosCadastroFuncionario(

    @NotBlank
    String nome,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cpf,

    @NotNull @Valid
    DadosEndereco endereco){

    }

