package br.ufpb.dcx.apivendas.mapper;

import br.ufpb.dcx.apivendas.dto.VendaDTO;
import br.ufpb.dcx.apivendas.model.Venda;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VendaMapper {
    private final ModelMapper modelMapper;

    public VendaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VendaDTO toDTO(Venda venda) {
       return this.modelMapper.map(venda, VendaDTO.class);
    }

    public Venda toEntity(VendaDTO vendaDTO) {
        return this.modelMapper.map(vendaDTO, Venda.class);
    }
}
