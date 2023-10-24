package br.igor.Restaurante.cliente;

import br.igor.Restaurante.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
