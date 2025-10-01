package br.ufpb.dcx.apivendas.repository;


import br.ufpb.dcx.apivendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    boolean existsById(Long id);
    Venda getById(Long id);
}
