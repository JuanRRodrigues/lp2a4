package br.igor.Restaurante.repository;

import br.igor.Restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Pedido, Long> {
}
