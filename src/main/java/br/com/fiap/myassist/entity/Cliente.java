package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoDocumentoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Pessoa {

    private Long id;

    private String documento;

    private TipoDocumentoEnum tipoDocumento;

}
