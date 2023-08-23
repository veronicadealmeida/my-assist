package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EquipamentoController {
    @GetMapping("/tipos")
    public List<TipoEquipamentoEnum> getTiposEquipamento() {
        return List.of(TipoEquipamentoEnum.values());
    }

}
