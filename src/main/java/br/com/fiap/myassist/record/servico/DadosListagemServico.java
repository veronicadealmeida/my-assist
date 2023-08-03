package br.com.fiap.myassist.record.servico;

import br.com.fiap.myassist.entity.Servico;

import java.math.BigDecimal;

public record DadosListagemServico(Long id, String descricao, BigDecimal valor) {

    public DadosListagemServico(Servico servico) {
        this(servico.getId(), servico.getDescricao(), servico.getValor());
    }
}
