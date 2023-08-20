package br.igor.Restaurante.model;

import br.igor.Restaurante.dto.CardapioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="pratos")
@Entity(name = "prato")
public class Prato {
    private static Long idBase = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private Double preco;

    public Prato(CardapioRequestDTO data) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.preco = data.preco();
        this.id = idBase++;
    }
}
