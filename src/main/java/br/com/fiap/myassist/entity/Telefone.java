package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoTelefoneEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telefone {

    private String area;

    private String numero;

    private TipoTelefoneEnum tipo;

}
