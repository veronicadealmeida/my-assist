package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.record.tecnico.DadosCadastroTecnico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_TECNICO")
public class Tecnico extends Pessoa {

    @Id
    @Column(name = "ID_TECNICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Tecnico(DadosCadastroTecnico dados) {
        super();
    }
}
