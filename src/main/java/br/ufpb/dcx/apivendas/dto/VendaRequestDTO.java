package br.ufpb.dcx.apivendas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequestDTO {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long funcionarioId;

    @NotNull
    private Long veiculoId;

    @NotNull
    private BigDecimal valor;
}
