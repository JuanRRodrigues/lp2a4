package br.igor.Restaurante.cliente;

import br.igor.Restaurante.cliente.Cliente;
import br.igor.Restaurante.endereco.Endereco;

public record DadosListagemCliente(

        Long id,
        String nome,
        String email,
        String cpf,
        Endereco endereco
) {
    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getEndereco());
    }

}
