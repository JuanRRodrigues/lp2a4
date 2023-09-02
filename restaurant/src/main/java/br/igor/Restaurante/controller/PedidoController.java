package br.igor.Restaurante.controller;


import br.igor.Restaurante.cardapio.CardapioRepository;
import br.igor.Restaurante.cliente.ClienteRepository;
import br.igor.Restaurante.pedido.Pedido;
import br.igor.Restaurante.pedido.PedidoRepository;
import br.igor.Restaurante.pedido.PedidoRequestDTO;
import br.igor.Restaurante.pedido.PedidoResponseDTO;
import br.igor.Restaurante.prato.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository repositoryCliente;

    @Autowired
    private CardapioRepository repositoryPratos;

    @GetMapping
    public List<PedidoResponseDTO> getAll(){
        return repository.findAll().stream().map(PedidoResponseDTO::new).toList();
    }

    @PostMapping
    public void savePedido(@RequestBody PedidoRequestDTO data){
        List<Prato> p = new ArrayList<>();
        for (Long id: data.pratos()) {
            p.add(repositoryPratos.findById(id).get());
        }
        repository.save(new Pedido(data.title(), repositoryCliente.findById(data.cliente()).get(), p));
    }
}