package com.gabriel.kafka.vendas.domain.repositories;

import com.gabriel.kafka.vendas.domain.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendasRepository extends JpaRepository<Vendas, UUID> {
}