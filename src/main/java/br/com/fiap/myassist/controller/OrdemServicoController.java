package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.dto.OrdemServicoAtualizacaoDTO;
import br.com.fiap.myassist.dto.OrdemServicoInsercaoDTO;
import br.com.fiap.myassist.dto.OrdemServicoResponseDTO;
import br.com.fiap.myassist.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ordens-servico")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService osService;

    @GetMapping
    public List<OrdemServicoResponseDTO> listarTodos() {
        return osService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<OrdemServicoResponseDTO> inserir(@RequestBody @Valid OrdemServicoInsercaoDTO body) {
        var salvo = osService.inserir(body);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> buscarPorId(@PathVariable Long id) {
        var resultado = osService.buscarPorId(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> finalizar(@PathVariable Long id) {
        var resultado = osService.finalizar(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> atualizar(@PathVariable Long id,
                                                             @RequestBody @Valid OrdemServicoAtualizacaoDTO body) {
        var resultado = osService.atualizar(id, body);
        return ResponseEntity.ok(resultado);
    }



}
