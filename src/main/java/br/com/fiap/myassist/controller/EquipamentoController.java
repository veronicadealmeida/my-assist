package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Equipamento;
import br.com.fiap.myassist.record.equipamento.DadosCadastroEquipamento;
import br.com.fiap.myassist.record.equipamento.DadosListagemEquipamento;
import br.com.fiap.myassist.repository.EquipamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("equipamentos")
public class EquipamentoController {
    @Autowired
    private EquipamentoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroEquipamento dados) {
        repository.save(new Equipamento(dados));
    }

    @GetMapping
    public Page<DadosListagemEquipamento> listar(@PageableDefault(size = 10, sort = {"marca","modelo"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemEquipamento::new);

    }
}
