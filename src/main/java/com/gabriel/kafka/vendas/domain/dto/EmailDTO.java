package com.gabriel.kafka.vendas.domain.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO implements Serializable {

    private String nomeDestino;
    private String emailDestino;
    private String mensagem;
}
