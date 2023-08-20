package br.igor.Restaurante.model;


import br.igor.Restaurante.dto.CardapioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="cliente")
@Entity(name = "cliente")
public class Cliente {

    private static Long idBase = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereço_id")
    private Endereco enderoco;


    public Endereco getEndereco() {
        return enderoco;
    }
}
