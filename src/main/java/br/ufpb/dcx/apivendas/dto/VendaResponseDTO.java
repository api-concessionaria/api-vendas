package br.ufpb.dcx.apivendas.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaResponseDTO {

    private Long id;

    private Long clienteId;

    private Long funcionarioId;

    private Long veiculoId;

    private BigDecimal valor;

    private LocalDateTime dataVenda;
}
