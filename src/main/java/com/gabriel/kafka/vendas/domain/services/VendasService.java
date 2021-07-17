package com.gabriel.kafka.vendas.domain.services;

import com.gabriel.kafka.vendas.domain.dto.VendaDTO;
import com.gabriel.kafka.vendas.domain.vo.VendaVO;
import org.springframework.stereotype.Service;

@Service
public interface VendasService {

    public VendaDTO salvarVenda(VendaVO venda) throws Exception;
}
