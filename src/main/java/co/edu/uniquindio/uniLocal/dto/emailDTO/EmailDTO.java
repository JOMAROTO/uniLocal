package co.edu.uniquindio.uniLocal.dto.emailDTO;

import jakarta.validation.constraints.NotBlank;

public record EmailDTO(
        @NotBlank String asunto,
        @NotBlank String cuerpo,
        @NotBlank String destinatario
) {
}
