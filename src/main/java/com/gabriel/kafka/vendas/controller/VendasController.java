package com.gabriel.kafka.vendas.controller;

import com.gabriel.kafka.vendas.domain.dto.VendaDTO;
import com.gabriel.kafka.vendas.domain.services.VendasService;
import com.gabriel.kafka.vendas.domain.vo.VendaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VendasController {

    private final VendasService vendasService;

    @PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaDTO> salvarVenda(@RequestBody VendaVO vendaVO) throws Exception {

        return ResponseEntity.created(new URI("/salvar")).body(vendasService.salvarVenda(vendaVO));

    }
}
