package br.com.fiap.myassist.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Observacao {

    private Long id;

    private LocalDateTime data;

    private String texto;

    private OrdemServico ordemServico;

}
