package br.com.fiap.myassist.record.equipamento;

import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEquipamento(
        @NotNull
        String marca,
        String modelo,
        @NotNull
        String numeroSerie,
        @NotNull
        TipoEquipamentoEnum tipo
) {
}
