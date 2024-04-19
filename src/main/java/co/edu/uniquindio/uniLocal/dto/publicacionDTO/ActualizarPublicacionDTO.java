package co.edu.uniquindio.uniLocal.dto.publicacionDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ActualizarPublicacionDTO(
        @NotBlank String idPublicacion,
        @NotBlank String rutaImagen,
        @NotBlank @Min(20) @Max(500) String descripcion
        //Revisar lo de imagenes
) {
}
