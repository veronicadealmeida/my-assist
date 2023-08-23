package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.dto.ServicoAtualizacaoDTO;
import br.com.fiap.myassist.dto.ServicoInsercaoDTO;
import br.com.fiap.myassist.dto.ServicoResponseDTO;
import br.com.fiap.myassist.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servicos")
@Tag(name = "/servicos", description = "Recurso para gerenciar os serviços disponibilizados pela assistência técnica")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    @Operation(summary = "Consulta de serviços", description = "Consulta todos os serviços disponíveis na Assistência Técnica")
    @ApiResponse(responseCode = "200", description = "Serviços foram encontrados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno da aplicação")
    public List<ServicoResponseDTO> buscarTodos() {
        log.info("Inicio da busca de todos os servicos disponiveis");
        var resultado = servicoService.buscarTodos();
        log.info("Registros encontrados: {}", resultado.size());
        return resultado;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> buscarPorId(@PathVariable Long id) {
        var resultado = servicoService.buscarPorId(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado.get());
    }


    @PostMapping
    public ResponseEntity<ServicoResponseDTO> inserir(@RequestBody @Valid ServicoInsercaoDTO body) {
        log.info("Criacao de um novo servico: {}", body);
        var salvo = servicoService.inserir(body);
        log.info("Servico criado: {}", salvo);
        return ResponseEntity.ok(salvo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizar(@PathVariable Long id,
                                                        @RequestBody @Valid ServicoAtualizacaoDTO body) {
        var resultado = servicoService.atualizar(id, body);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var resultado = servicoService.excluir(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


}
