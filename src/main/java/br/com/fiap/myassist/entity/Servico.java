package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.record.servico.DadosCadastroServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_SERVICO")
public class Servico {

    @Id
    @Column(name = "ID_SERVICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "NR_VALOR")
    private BigDecimal valor;

    public Servico(DadosCadastroServico dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
    }

}
