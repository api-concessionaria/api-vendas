package br.ufpb.dcx.apivendas.mapper;

import br.ufpb.dcx.apivendas.dto.VendaRequestDTO;
import br.ufpb.dcx.apivendas.dto.VendaResponseDTO;
import br.ufpb.dcx.apivendas.model.Venda;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VendaMapper {
    private final ModelMapper modelMapper;

    public VendaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VendaResponseDTO toDTO(Venda venda) {
       return this.modelMapper.map(venda, VendaResponseDTO.class);
    }

    public Venda toEntity(VendaRequestDTO vendaRequestDTO) {
        return this.modelMapper.map(vendaRequestDTO, Venda.class);
    }
}
