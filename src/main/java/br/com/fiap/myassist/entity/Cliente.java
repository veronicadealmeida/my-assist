package br.com.fiap.myassist.entity;

import br.com.fiap.myassist.enums.TipoDocumentoEnum;
import br.com.fiap.myassist.record.cliente.DadosCadastroCliente;
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
@Table(name = "TBL_CLIENTE")
public class Cliente extends Pessoa {

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_DOCUMENTO")
    private String documento;

    @Column(name = "TX_TIPO_DOCUMENTO")
    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;

    public Cliente(DadosCadastroCliente dados){
        this.nome = dados.nome();
        this.documento = dados.documento();
        this.tipoDocumento = dados.tipoDocumento();
        this.email = dados.email();
        this.documento = dados.documento();
        this.telefone = dados.telefone();
    }

}
