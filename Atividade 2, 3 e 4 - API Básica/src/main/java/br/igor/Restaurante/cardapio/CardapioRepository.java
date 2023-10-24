package br.igor.Restaurante.cardapio;

import br.igor.Restaurante.prato.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Prato, Long> {
}
