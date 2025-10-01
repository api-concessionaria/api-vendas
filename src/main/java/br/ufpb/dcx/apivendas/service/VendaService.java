package br.ufpb.dcx.apivendas.service;

import br.ufpb.dcx.apivendas.exception.EntityNotFoundException;
import br.ufpb.dcx.apivendas.exception.VendaNotFoundException;
import br.ufpb.dcx.apivendas.model.Venda;
import br.ufpb.dcx.apivendas.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final RestTemplate restTemplate;

    public VendaService(VendaRepository vendaRepository, RestTemplate restTemplate) {
        this.vendaRepository = vendaRepository;
        this.restTemplate = restTemplate;
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

    @Transactional
    public Venda criarVenda(Venda novaVenda) {
        try {
            restTemplate.getForObject("http://cliente-service/api/clientes/" + novaVenda.getClienteId(), String.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException("Cliente não encontrado!");
        }
        try {
            restTemplate.getForObject("http://funcionario-service/api/funcionarios/" + novaVenda.getFuncionarioId(), String.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException("Funcionário não encontrado!");
        }
        try {
            restTemplate.getForObject("http://veiculo-service/api/veiculos/" + novaVenda.getVeiculoId(), String.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException("Veículo não encontrado!");
        }

        novaVenda.setDataVenda(LocalDateTime.now());
        return vendaRepository.save(novaVenda);
    }

}
