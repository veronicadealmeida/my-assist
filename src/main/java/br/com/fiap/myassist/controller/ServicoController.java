package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Servico;
import br.com.fiap.myassist.record.servico.DadosCadastroServico;
import br.com.fiap.myassist.record.servico.DadosListagemServico;
import br.com.fiap.myassist.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("servico")
public class ServicoController {
    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public Page<DadosListagemServico> listar(@PageableDefault(size = 10, sort = {"descricao"})Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemServico::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroServico dados){
        repository.save(new Servico(dados));
    }


}
