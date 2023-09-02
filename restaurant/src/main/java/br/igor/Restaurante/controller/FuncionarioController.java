package br.igor.Restaurante.controller;

import br.igor.Restaurante.cliente.Cliente;
import br.igor.Restaurante.cliente.DadosAtualizacaoCliente;
import br.igor.Restaurante.cliente.DadosCadastroCliente;
import br.igor.Restaurante.cliente.DadosListagemCliente;
import br.igor.Restaurante.cliente.ClienteRepository;
import br.igor.Restaurante.funcionario.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repository;


    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroFuncionario dados){
        repository.save(new Funcionario(dados));
    }

    @GetMapping
    public Page<DadosListagemFuncionario> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {

        return repository.findAll(paginacao).map(DadosListagemFuncionario::new);
    }



    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
       var funcionario = repository.getReferenceById(dados.id());
       funcionario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
