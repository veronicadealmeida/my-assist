package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.record.ordemservico.DadosListagemOrdemServico;
import br.com.fiap.myassist.repository.OrdemServicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ordensservico")
public class OrdemServicoController {

    private OrdemServicoRepository repository;

    @GetMapping
    public Page<DadosListagemOrdemServico> listar(@PageableDefault(size = 10, sort = {"prioridade"})Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemOrdemServico::new);
    }
}
