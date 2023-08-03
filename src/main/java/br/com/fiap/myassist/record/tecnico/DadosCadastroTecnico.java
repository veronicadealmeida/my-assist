package br.com.fiap.myassist.record.tecnico;

import br.com.fiap.myassist.entity.Telefone;

public record DadosCadastroTecnico(
        String nome,
        String email,
        Telefone telefone
) {
}
