package br.igor.Restaurante.funcionario;

import br.igor.Restaurante.cliente.DadosAtualizacaoCliente;
import br.igor.Restaurante.cliente.DadosCadastroCliente;
import br.igor.Restaurante.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="funcionario")
@Entity(name = "funcionario")
@EqualsAndHashCode(of = "id")

public class Funcionario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private String cpf;

    @Embedded
    Endereco endereco;

    public Funcionario(DadosCadastroFuncionario dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoFuncionario dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
}
