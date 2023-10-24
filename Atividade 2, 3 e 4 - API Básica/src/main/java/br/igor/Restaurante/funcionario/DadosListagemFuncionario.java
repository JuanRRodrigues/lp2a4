package br.igor.Restaurante.funcionario;

import br.igor.Restaurante.cliente.Cliente;
import br.igor.Restaurante.endereco.Endereco;

public record DadosListagemFuncionario(

        Long id,
        String nome,
        String cpf,
        Endereco endereco
) {
    public DadosListagemFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getEndereco());
    }

}
