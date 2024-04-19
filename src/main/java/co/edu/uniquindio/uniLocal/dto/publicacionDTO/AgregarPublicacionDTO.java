package co.edu.uniquindio.uniLocal.dto.publicacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgregarPublicacionDTO(
        @NotBlank @Min(20) @Max(500) String descripcion,
        @NotBlank String rutaImagen,
        @NotBlank String idCliente,
        @NotNull LocalDateTime fechaPublicacion
) {
}
