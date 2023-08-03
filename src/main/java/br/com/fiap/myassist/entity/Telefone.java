package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoTelefoneEnum;
import br.com.fiap.myassist.record.cliente.DadosCadastroCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Telefone {

    @Column(name = "TX_AREA_FONE")
    private String area;

    @Column(name = "TX_FONE")
    private String numero;

    @Column(name = "TX_TIPO_FONE")
    @Enumerated(EnumType.STRING)
    private TipoTelefoneEnum tipo;

    public Telefone(Telefone dados) {
            this.area = dados.area;
            this.numero = dados.numero;
            this.tipo = dados.tipo;
    }

}
