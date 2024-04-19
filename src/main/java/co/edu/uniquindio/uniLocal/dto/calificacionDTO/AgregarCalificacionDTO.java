package co.edu.uniquindio.uniLocal.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

public record AgregarCalificacionDTO(

        @NotBlank String codigoCliente,
        @NotBlank String codigoNegocio,
        @NotNull LocalDateTime fecha,
        @NotNull @Range(min = 1, max = 5) int valoracion,
        @NotBlank @Min(20) @Max(300) String mensaje
) {
}
