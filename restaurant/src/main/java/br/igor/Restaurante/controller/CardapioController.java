package br.igor.Restaurante.controller;

import br.igor.Restaurante.dto.CardapioRequestDTO;
import br.igor.Restaurante.dto.CardapioResponseDTO;
import br.igor.Restaurante.model.Prato;
import br.igor.Restaurante.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {

    @Autowired
    CardapioRepository cardapioRepository;
    private List<Prato> pratos = new ArrayList<>();




    @GetMapping
    public List<CardapioResponseDTO> getAll() {

        return cardapioRepository.findAll().stream().map(CardapioResponseDTO::new).toList();
    }

    @PostMapping
    public void addPrato(@RequestBody CardapioRequestDTO data){
        pratos.add(new Prato(data));
    }

    @DeleteMapping("/{id}")
    public void deletePrato(@PathVariable Long id){
        cardapioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void alterarPrato(@PathVariable Long id, @RequestBody CardapioRequestDTO data){
        Prato prato = new Prato(data);
        prato.setId(id);
        cardapioRepository.save(prato);
    }


}
