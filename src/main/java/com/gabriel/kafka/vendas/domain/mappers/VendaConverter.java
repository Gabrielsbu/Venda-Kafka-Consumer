package com.gabriel.kafka.vendas.domain.mappers;


import com.gabriel.kafka.vendas.domain.dto.VendaDTO;
import com.gabriel.kafka.vendas.domain.models.Vendas;
import com.gabriel.kafka.vendas.domain.vo.VendaVO;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Service
public class VendaConverter {

    private final ModelMapper modelMapper;

    public VendaDTO toModel(Vendas vendas) {
        return modelMapper.map(vendas, VendaDTO.class);
    }

    public Vendas toDTO(VendaDTO vendaDTO) {
        return modelMapper.map(vendaDTO, Vendas.class);
    }

    public VendaVO toModelVO(Vendas vendas) {
        return modelMapper.map(vendas, VendaVO.class);
    }

    public Vendas toVO(VendaVO vendaVO) {
        return modelMapper.map(vendaVO, Vendas.class);
    }

}
