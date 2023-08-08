package br.com.fiap.myassist.record.ordemservico;

import br.com.fiap.myassist.entity.Equipamento;
import br.com.fiap.myassist.entity.OrdemServico;
import br.com.fiap.myassist.entity.Tecnico;
import br.com.fiap.myassist.enums.PrioridadeExecucaoEnum;
import br.com.fiap.myassist.enums.StatusExecucaoEnum;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemOrdemServico(
        Long id
//        Equipamento equipamento,
//        LocalDateTime dataEntrada,
//        LocalDateTime dataPrevisao,
//        String defeito,
//        PrioridadeExecucaoEnum prioridade,
//        List<Tecnico> responsaveis,
//        LocalDateTime dataSaida,
//        StatusExecucaoEnum status
) {

    public DadosListagemOrdemServico(OrdemServico ordemServico){
        this(
                ordemServico.getId()
//                ordemServico.getEquipamento(),
//                ordemServico.getDataEntrada()
//                ,ordemServico.getDataPrevisao(),
//                ordemServico.getDefeito(),
//                ordemServico.getPrioridade(),
//                ordemServico.getDataSaida(),
//                ordemServico.getStatus()
                );
    }
}
