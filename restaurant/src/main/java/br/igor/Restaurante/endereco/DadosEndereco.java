package br.igor.Restaurante.endereco;

import javax.validation.constraints.NotBlank;

    public record DadosEndereco(

            @NotBlank
            String logradouro,
            @NotBlank
            String bairro,
            @NotBlank
            String cep,
            @NotBlank
            String cidade,
            @NotBlank
            String uf,
            String complemento,
            String numero) {
    }

