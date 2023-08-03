package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Cliente;
import br.com.fiap.myassist.entity.Tecnico;
import br.com.fiap.myassist.record.cliente.DadosCadastroCliente;
import br.com.fiap.myassist.record.equipamento.DadosListagemEquipamento;
import br.com.fiap.myassist.record.tecnico.DadosCadastroTecnico;
import br.com.fiap.myassist.record.tecnico.DadosListagemTecnico;
import br.com.fiap.myassist.repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoRepository repository;

    @GetMapping
    public Page<DadosListagemTecnico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemTecnico::new);

    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTecnico dados) {
        repository.save(new Tecnico(dados));
    }
}
