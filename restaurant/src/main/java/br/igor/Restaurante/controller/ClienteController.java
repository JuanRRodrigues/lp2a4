package br.igor.Restaurante.controller;

import br.igor.Restaurante.dto.CardapioRequestDTO;
import br.igor.Restaurante.dto.CardapioResponseDTO;
import br.igor.Restaurante.dto.ClienteRequestDTO;
import br.igor.Restaurante.dto.ClienteResponseDTO;
import br.igor.Restaurante.model.Cliente;
import br.igor.Restaurante.model.Prato;
import br.igor.Restaurante.repository.CardapioRepository;
import br.igor.Restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<ClienteResponseDTO> getAll() {

        return clienteRepository.findAll().stream().map(ClienteResponseDTO::new).toList();
    }

    @PostMapping
    public void addCliente(@RequestBody ClienteRequestDTO data){
        clientes.add(new Cliente());
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void alterarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO data){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        clienteRepository.save(cliente);
    }


}
