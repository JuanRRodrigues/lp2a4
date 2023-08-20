package br.igor.Restaurante.dto;

import br.igor.Restaurante.model.Cliente;
import br.igor.Restaurante.model.Endereco;
import br.igor.Restaurante.model.Prato;

public record ClienteResponseDTO(Long id, String Nome, Endereco endereco) {
    public ClienteResponseDTO(Cliente c){
       this(c.getId(), c.getNome(), c.getEndereco());
    }
    
}
