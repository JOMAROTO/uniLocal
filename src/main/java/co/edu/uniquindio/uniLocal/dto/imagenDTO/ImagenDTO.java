package co.edu.uniquindio.uniLocal.dto.imagenDTO;

import jakarta.validation.constraints.NotBlank;

public record ImagenDTO(
        @NotBlank String id,
        @NotBlank String url
) {
}
