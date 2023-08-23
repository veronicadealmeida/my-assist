package br.com.fiap.myassist.dto;

import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoResponseDTO {

    private Long id;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private TipoEquipamentoEnum tipo;

}
