package co.edu.uniquindio.uniLocal.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalleCalificacionDTO(
        @NotBlank String codigoCalificacion,
        @NotBlank String codigoNegocio,
        @NotBlank String codigoCliente,
        @NotNull LocalDateTime fecha,
        @NotNull int valoracion,
        @NotBlank @Min(20) @Max(300) String mensaje,
        @NotBlank String respuesta) {
}
