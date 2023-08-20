package br.igor.Restaurante.model;

import br.igor.Restaurante.dto.CardapioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="funcionario")
@Entity(name = "funcionario")

public class Funcionario {

    private static Long idBase = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;


}
