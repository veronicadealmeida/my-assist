package br.com.fiap.myassist.record.servico;

import br.com.fiap.myassist.entity.Servico;

import java.math.BigDecimal;

public record DadosDetalhamentoServico(Long id, String descricao, BigDecimal valor) {

    public DadosDetalhamentoServico(Servico servico){
        this(servico.getId(), servico.getDescricao(), servico.getValor());
    }
}
