package br.com.fiap.myassist.record.equipamento;

import br.com.fiap.myassist.entity.Equipamento;
import br.com.fiap.myassist.enums.TipoEquipamentoEnum;

public record DadosListagemEquipamento(
        Long id,
        String marca,
        String modelo,
        String numeroSerie,
        TipoEquipamentoEnum tipo) {

    public DadosListagemEquipamento(Equipamento equipamento){
        this(equipamento.getId(), equipamento.getMarca(), equipamento.getModelo(), equipamento.getNumeroSerie(), equipamento.getTipo());
    }
}
