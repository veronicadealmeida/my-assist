package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Servico;
import br.com.fiap.myassist.record.servico.DadosCadastroServico;
import br.com.fiap.myassist.record.servico.DadosDetalhamentoServico;
import br.com.fiap.myassist.record.servico.DadosListagemServico;
import br.com.fiap.myassist.repository.ServicoRepository;
import jakarta.persistence.MapKey;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("servicos")
public class ServicoController {
    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemServico>> listar(@PageableDefault(size = 10, sort = {"descricao"})Pageable paginacao) {
        var page =  repository.findAll(paginacao).map(DadosListagemServico::new);
        return ResponseEntity.ok(page);


    }

    @GetMapping("/{id}")
    public Optional<Servico> buscarPorId(@PathVariable Long id){
        var resultado = repository.findById(id);

        if (resultado.isEmpty()){
            return null;
        }
        return resultado;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroServico dados, UriComponentsBuilder uriBuilder){
        var servico = new Servico(dados);
        repository.save(servico);

        var uri =uriBuilder.path("/servicos/{id}").buildAndExpand(servico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoServico(servico));
    }


}
