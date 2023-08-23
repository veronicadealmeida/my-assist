package br.com.fiap.myassist.dto;

import br.com.fiap.myassist.enums.TipoDocumentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDTO {

    private Long id;
    private TipoDocumentoEnum tipoDocumento;
    private String nome;

}
