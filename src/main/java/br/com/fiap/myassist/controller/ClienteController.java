package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Cliente;
import br.com.fiap.myassist.entity.Equipamento;
import br.com.fiap.myassist.record.cliente.DadosCadastroCliente;
import br.com.fiap.myassist.record.cliente.DadosListagemCliente;
import br.com.fiap.myassist.record.equipamento.DadosCadastroEquipamento;
import br.com.fiap.myassist.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public Page<DadosListagemCliente> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemCliente::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }
}
