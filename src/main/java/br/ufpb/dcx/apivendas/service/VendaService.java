package br.ufpb.dcx.apivendas.service;

import br.ufpb.dcx.apivendas.exception.VendaNotFoundException;
import br.ufpb.dcx.apivendas.model.Venda;
import br.ufpb.dcx.apivendas.repository.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVenda(Long id) {
        if(!vendaRepository.existsById(id)) {
            throw new VendaNotFoundException("Venda não encontrada!");
        }
        return vendaRepository.getById(id);
    }

    public Venda createVenda(Venda novaVenda) {
        novaVenda.setDataVenda(LocalDateTime.now());
        return vendaRepository.save(novaVenda);
    }

    public Venda updateVenda(Long id,Venda novaVenda) {
        Venda venda = vendaRepository.getById(id);
        venda.setClienteId(novaVenda.getClienteId());
        venda.setDataVenda(LocalDateTime.now());
        venda.setValor(novaVenda.getValor());
        venda.setFuncionarioId(novaVenda.getFuncionarioId());
        venda.setVeiculoId(novaVenda.getVeiculoId());
        return vendaRepository.save(venda);
    }

    public void deleteVenda(Long idVenda) {
        vendaRepository.deleteById(idVenda);
    }



}
