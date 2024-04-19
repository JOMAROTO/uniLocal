package co.edu.uniquindio.uniLocal.dto.calificacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ResponderCalificacionDTO(
        @NotBlank String idCalificacion,
        @NotBlank @Min(20) @Max(300) String respuesta
) {
}
