package br.igor.Restaurante.repository;

import br.igor.Restaurante.model.Cliente;
import br.igor.Restaurante.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
