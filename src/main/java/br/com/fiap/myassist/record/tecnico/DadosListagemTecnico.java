package br.com.fiap.myassist.record.tecnico;

import br.com.fiap.myassist.entity.Tecnico;
import br.com.fiap.myassist.entity.Telefone;

public record DadosListagemTecnico(
        Long id,
        String nome,
        String email,
        Telefone telefone
) {
    public DadosListagemTecnico(Tecnico tecnico) {
        this(tecnico.getId(), tecnico.getNome(), tecnico.getEmail(),tecnico.getTelefone());
    }
}
