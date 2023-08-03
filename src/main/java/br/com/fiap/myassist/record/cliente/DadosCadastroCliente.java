package br.com.fiap.myassist.record.cliente;

import br.com.fiap.myassist.entity.Telefone;
import br.com.fiap.myassist.enums.TipoDocumentoEnum;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
        String nome,
        String documento,
        TipoDocumentoEnum tipoDocumento,
        String email,
        Telefone telefone

) {
}
