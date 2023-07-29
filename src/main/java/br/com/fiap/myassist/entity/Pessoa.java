package br.com.fiap.myassist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Pessoa {

    @Column(name = "TX_NOME")
    protected String nome;

    @Embedded
    protected Telefone telefone;

    @Column(name = "TX_EMAIL")
    protected String email;

}
