package br.igor.Restaurante.cardapio;

import br.igor.Restaurante.prato.Prato;

public record CardapioResponseDTO(Long id, String titulo, String descricao, Double preco) {
    public CardapioResponseDTO(Prato p){
        this(p.getId(), p.getTitulo(), p.getDescricao(), p.getPreco());
    }
}
