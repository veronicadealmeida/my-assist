package br.com.fiap.myassist.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ServicoInsercaoDTO {

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 80, message = "Descrição tem tamanho máximo de 80 caracteres")
    private String descricao;

    @DecimalMin(value = "20.00", message = "Valor deve ser maior ou igual a 20 reais")
    @Digits(fraction = 2, integer = 4, message = "Valor inválido para casas decimais")
    private BigDecimal valor;

}
