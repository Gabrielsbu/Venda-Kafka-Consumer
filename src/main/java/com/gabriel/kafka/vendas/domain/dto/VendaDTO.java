package com.gabriel.kafka.vendas.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO implements Serializable {

    private UUID vendasId;
    private String nomeProduto;
    private Double precoProduto;
    private Integer quantidadeProduto;
    private String nomeCliente;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
