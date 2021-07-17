package com.gabriel.kafka.vendas.domain.vo;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
public class VendaVO implements Serializable {

    @NotEmpty(message = "O nome do produto não pode ser vazio")
    private String nomeProduto;

    @NotEmpty(message = "O preço do produto não pode ser vazio")
    private Double precoProduto;

    @NotNull(message = "A quantidade do produto não pode ser nula")
    private Integer quantidadeProduto;

    private String nomeCliente;
}
