package br.igor.Restaurante.cliente;

import br.igor.Restaurante.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record DadosCadastroCliente(

    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cpf,

    @NotNull @Valid
    DadosEndereco endereco){

    }

