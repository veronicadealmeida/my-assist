package br.com.fiap.myassist.record.cliente;

import br.com.fiap.myassist.entity.Cliente;
import br.com.fiap.myassist.entity.Telefone;
import br.com.fiap.myassist.enums.TipoDocumentoEnum;

public record DadosListagemCliente(
        Long id,
        String nome,
        String documento,
        TipoDocumentoEnum tipoDocumento,
        String email,
        Telefone telefone) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getDocumento(), cliente.getTipoDocumento(), cliente.getEmail(), cliente.getTelefone());
    }
}
