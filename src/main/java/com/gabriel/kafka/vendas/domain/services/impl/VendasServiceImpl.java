package com.gabriel.kafka.vendas.domain.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.kafka.vendas.domain.dto.EmailDTO;
import com.gabriel.kafka.vendas.domain.dto.VendaDTO;
import com.gabriel.kafka.vendas.domain.mappers.VendaConverter;
import com.gabriel.kafka.vendas.domain.models.Vendas;
import com.gabriel.kafka.vendas.domain.repositories.VendasRepository;
import com.gabriel.kafka.vendas.domain.services.VendasService;
import com.gabriel.kafka.vendas.domain.vo.VendaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendasServiceImpl implements VendasService {

    private final VendasRepository repository;
    private final VendaConverter vendaConverter;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public VendaDTO salvarVenda(VendaVO venda) throws Exception {
        Vendas vendasSalva = this.vendaConverter.toVO(venda);

        Vendas vendaSalva = repository.save(vendasSalva);

        enviarMsgEmail(EmailDTO.builder().setEmailDestino("gabrielmaiasbu@gmail.com")
                .setMensagem("Venda cadastrada com sucesso").setNomeDestino("CRISTIANO RODRIGUES DE LIMA").build());
        return vendaConverter.toModel(vendaSalva);
    }

    private void enviarMsgEmail(EmailDTO email) throws Exception {
        this.kafkaTemplate
                .send("enviar-email", UUID.randomUUID().toString(), getString(email));
    }

    private String getString(EmailDTO email) throws Exception {
        try {
            return objectMapper.writeValueAsString(email);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
