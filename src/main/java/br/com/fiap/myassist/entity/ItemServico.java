package br.com.fiap.myassist.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemServico {

    private Long id;

    private OrdemServico ordemServico;

    private Servico servico;

    private BigDecimal valor;

}
