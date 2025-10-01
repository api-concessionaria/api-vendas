package br.ufpb.dcx.apivendas.controller;

import br.ufpb.dcx.apivendas.dto.VendaDTO;
import br.ufpb.dcx.apivendas.mapper.VendaMapper;
import br.ufpb.dcx.apivendas.model.Venda;
import br.ufpb.dcx.apivendas.service.VendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class VendaController {

    private final VendaService vendaService;
    private final VendaMapper vendaMapper;

    public VendaController(VendaService vendaService, VendaMapper vendaMapper) {
        this.vendaService = vendaService;
        this.vendaMapper = vendaMapper;
    }

    @GetMapping(path = "/vendas")
    public List<VendaDTO> vendas() {
        return this.vendaService.getVendas().stream().map(vendaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "vendas/{id}")
    public VendaDTO venda(@PathVariable Long id){
        Venda venda = vendaService.getVenda(id);
        return vendaMapper.toDTO(venda);
    }

    @PostMapping(path = "/vendas")
    public VendaDTO cadastrarVenda(@RequestBody VendaDTO vendaDTO) {
        Venda venda = vendaMapper.toEntity(vendaDTO);
        this.vendaService.criarVenda(venda);
        return vendaMapper.toDTO(venda);
    }


}
