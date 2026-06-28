package br.ufpb.dcx.apivendas.controller;

import br.ufpb.dcx.apivendas.dto.VendaRequestDTO;
import br.ufpb.dcx.apivendas.dto.VendaResponseDTO;
import br.ufpb.dcx.apivendas.mapper.VendaMapper;
import br.ufpb.dcx.apivendas.model.Venda;
import br.ufpb.dcx.apivendas.service.VendaService;
import org.springframework.http.HttpStatus;
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
    public List<VendaResponseDTO> vendas() {
        return this.vendaService.getVendas().stream().map(vendaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "vendas/{id}")
    public VendaResponseDTO venda(@PathVariable Long id){
        Venda venda = vendaService.getVenda(id);
        return vendaMapper.toDTO(venda);
    }

    @PostMapping(path = "/vendas")
    public VendaResponseDTO cadastrarVenda(@RequestBody VendaRequestDTO vendaRequestDTO) {
        Venda venda = vendaMapper.toEntity(vendaRequestDTO);
        Venda vendaSalva = this.vendaService.createVenda(venda);
        return vendaMapper.toDTO(vendaSalva);
    }

    @PutMapping(path = "/vendas/{id}")
    public VendaResponseDTO editarVenda(@PathVariable Long id, @RequestBody VendaRequestDTO vendaRequestDTO) {
        Venda venda = vendaMapper.toEntity(vendaRequestDTO);
        Venda vendaAtualizada = this.vendaService.updateVenda(id, venda);
        return vendaMapper.toDTO(vendaAtualizada);
    }

    @DeleteMapping(path = "/vendas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarVenda(@PathVariable Long id){
        this.vendaService.deleteVenda(id);
    }

}
