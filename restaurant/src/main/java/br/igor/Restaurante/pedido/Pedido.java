package br.igor.Restaurante.pedido;

import br.igor.Restaurante.cliente.Cliente;
import br.igor.Restaurante.prato.Prato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="pedido")
@Entity(name = "pedido")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido-prato", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "prato_id"))
    private List<Prato> pratos;

    public Pedido(String titulo, Cliente cliente, List<Prato> pratos) {
        this.titulo = titulo;
        this.cliente = cliente;
        this.pratos = pratos;
    }


}
