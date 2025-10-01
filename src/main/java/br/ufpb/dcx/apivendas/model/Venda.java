package br.ufpb.dcx.apivendas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_vendas")
@Data
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "funcionario_id")
    private Long funcionarioId;

    @Column(name = "veiculo_id")
    private Long veiculoId;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "dataVenda")
    private LocalDateTime dataVenda;

}
