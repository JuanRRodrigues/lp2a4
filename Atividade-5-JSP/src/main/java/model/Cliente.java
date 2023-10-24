package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clientes")
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private Date dataDeNascimento;
    @Column
    private String cpf;
    @Column
    private String email;


    public Cliente(String nome, String sobrenome,Date dataDeNascimento, String cpf,String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.email = email;
    }
}
