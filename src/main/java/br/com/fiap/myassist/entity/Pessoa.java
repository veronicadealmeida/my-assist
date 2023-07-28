package br.com.fiap.myassist.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pessoa {

    protected String nome;

    protected Telefone telefone;

    protected String email;

}
