package br.igor.Restaurante.controller;

import br.igor.Restaurante.cliente.Cliente;
import br.igor.Restaurante.cliente.DadosAtualizacaoCliente;
import br.igor.Restaurante.cliente.DadosCadastroCliente;
import br.igor.Restaurante.cliente.DadosListagemCliente;
import br.igor.Restaurante.cliente.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteRepository repository;


    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {

        return repository.findAll(paginacao).map(DadosListagemCliente::new);
    }



    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
       var cliente = repository.getReferenceById(dados.id());
       cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
