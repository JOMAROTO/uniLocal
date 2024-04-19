package co.edu.uniquindio.uniLocal.dto.opinionDTO;

import jakarta.validation.constraints.NotBlank;

public record ReaccionarOpinionDTO(
        @NotBlank String idOpinion,
        @NotBlank String idCliente
) {
}
