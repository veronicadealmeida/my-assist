package br.com.fiap.myassist.record.servico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroServico(
        @NotBlank
        String descricao,
        @NotNull
        BigDecimal valor) {
}
