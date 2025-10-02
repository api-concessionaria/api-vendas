package br.ufpb.dcx.apivendas.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {

    @NotNull
    @NotBlank
    private Long clienteId;

    @NotNull
    @NotBlank
    private Long funcionarioId;

    @NotNull
    @NotBlank
    private Long veiculoId;

    @NotNull
    private BigDecimal valor;
}
