package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_EQUIPAMENTO")
public class Equipamento {

    @Id
    @Column(name = "ID_EQUIPAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_MARCA")
    private String marca;

    @Column(name = "TX_MODELO")
    private String modelo;

    @Column(name = "TX_NUMERO_SERIE")
    private String numeroSerie;

    @Column(name = "TX_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEquipamentoEnum tipo;

}
