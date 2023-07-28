package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.PrioridadeExecucaoEnum;
import br.com.fiap.myassist.enums.StatusExecucaoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrdemServico {

    private Long id;

    private Equipamento equipamento;

    private Cliente cliente;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataPrevisao;

    private String defeito;

    private PrioridadeExecucaoEnum prioridade;

    private List<Tecnico> responsaveis;

    private LocalDateTime dataSaida;

    private StatusExecucaoEnum status;

}
