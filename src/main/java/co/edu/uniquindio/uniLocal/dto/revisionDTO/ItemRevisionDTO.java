package co.edu.uniquindio.uniLocal.dto.revisionDTO;

import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoNegocio;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ItemRevisionDTO(
        @NotBlank String codigoRevision,
        @NotBlank LocalDateTime fecha,
        @NotBlank String codigoModerador,
        @NotBlank String codigoNegocio,
        @NotBlank String descripcion,
        @NotBlank EstadoNegocio estadoNegocio
) {
}
