package co.edu.uniquindio.uniLocal.dto.publicacionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record ItemPublicacionDTO(
        @NotBlank String codigoPublicacion,
        @NotBlank String codigoCliente,
        @NotBlank String descripcion,
        @NotEmpty List<String> listaMeGustas,
        @NotBlank String rutaImagen,
        @NotNull LocalDateTime fechaPublicacion
) {
}
