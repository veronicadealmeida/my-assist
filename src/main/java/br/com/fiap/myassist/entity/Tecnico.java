package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.record.tecnico.DadosCadastroTecnico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_TECNICO")
public class Tecnico extends Pessoa {

    @Id
    @Column(name = "ID_TECNICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    public Tecnico(DadosCadastroTecnico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

}
