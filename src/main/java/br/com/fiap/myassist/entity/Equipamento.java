package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equipamento {
    private Long id;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private TipoEquipamentoEnum tipo;
}
