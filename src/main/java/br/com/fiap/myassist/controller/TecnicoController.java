package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Tecnico;
import br.com.fiap.myassist.repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    public Page<Tecnico> listarTodos(@RequestParam(required = false) String email,
                                     @RequestParam(defaultValue = "0") int pagina,
                                     @RequestParam(defaultValue = "5") int tamanho) {
        var pageRequest = PageRequest.of(pagina, tamanho);

        if (email == null) {
            return tecnicoRepository.findAll(pageRequest);
        }

        return tecnicoRepository.findByEmail(email, pageRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> buscarPorId(@PathVariable Long id) {
        var resultado = tecnicoRepository.findById(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado.get());
    }

    @PostMapping
    public ResponseEntity<Tecnico> inserir(@RequestBody @Valid Tecnico tecnico) {
        var existe = tecnicoRepository.findByEmail(tecnico.getEmail());
        if (existe.isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");
        }
        var salvo = tecnicoRepository.save(tecnico);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> atualizar(@PathVariable Long id,
                                             @RequestBody @Valid Tecnico body) {
        var resultado = tecnicoRepository.findById(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var existente = tecnicoRepository.findByEmailIgnoreCaseAndIdNot(body.getEmail(), id);
        if (!existente.isEmpty()) {
            throw new RuntimeException("Já existe um e-mail cadastrado");
        }

        var salvo = tecnicoRepository.save(body);
        return ResponseEntity.ok(salvo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var resultado = tecnicoRepository.findById(id);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var existeOS = tecnicoRepository.findOrdensServicoBy(id);
        if (!existeOS.isEmpty()) {
            throw new RuntimeException("Técnico com OS vinculada.");
        }

        tecnicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
