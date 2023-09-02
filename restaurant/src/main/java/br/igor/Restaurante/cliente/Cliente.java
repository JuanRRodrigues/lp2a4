package br.igor.Restaurante.cliente;


import br.igor.Restaurante.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name ="cliente")
@Entity(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }
    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

}
