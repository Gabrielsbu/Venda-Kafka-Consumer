package com.gabriel.kafka.vendas.domain.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "venda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "vendas_id", unique = true, nullable = false)
    private UUID vendasId;

    @Column(name = "nome_produto", columnDefinition = "VARCHAR(100)", nullable = false)
    private String nomeProduto;

    @Column(name = "preco_produto", precision = 2, nullable = false)
    private Double precoProduto;

    @Column(name = "quantidade_produto", nullable = false)
    private Integer quantidadeProduto;

    @Column(name = "nome_cliente", columnDefinition = "VARCHAR(100)")
    private String nomeCliente;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
